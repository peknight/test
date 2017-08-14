/**
 * MIT License
 * <p>
 * Copyright (c) 2017-2027 PeKnight(JKpeknight@gmail.com)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.peknight.test.util;

import com.peknight.common.reflect.material.BeanMaterial;
import com.peknight.common.reflect.material.CollectionMaterial;
import com.peknight.common.reflect.material.ConstructorMaterial;
import com.peknight.common.reflect.material.EnumMaterial;
import com.peknight.common.reflect.material.MapMaterial;
import com.peknight.common.reflect.material.MethodMaterial;
import com.peknight.common.reflect.metadata.ClassMetadata;
import com.peknight.common.reflect.metadata.ConstructorMetadata;
import com.peknight.common.reflect.metadata.MethodMetadata;
import com.peknight.common.reflect.util.ClassUtils;
import com.peknight.test.thrift.reflect.BeanCall;
import com.peknight.test.thrift.reflect.ClassInfo;
import com.peknight.test.thrift.reflect.ConstructorCall;
import com.peknight.test.thrift.reflect.ConstructorInfo;
import com.peknight.test.thrift.reflect.MethodCall;
import com.peknight.test.thrift.reflect.MethodInfo;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Thrift结构体 转换类
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/8/10.
 */
public final class ConvertUtils {
    private ConvertUtils() {}

    public static List<ClassInfo> getClassInfoList(Set<ClassMetadata> metadataSet, List<ClassMetadata> classMetadataList, String[] searchPackages) throws IOException {
        if (classMetadataList == null) {
            return null;
        }
        List<ClassInfo> componentClassList = new ArrayList<>(classMetadataList.size());
        for (ClassMetadata metadata : classMetadataList) {
            componentClassList.add(getClassInfo(metadataSet, metadata, searchPackages));
        }
        return componentClassList;
    }

    public static ClassInfo getClassInfo(Set<ClassMetadata> metadataSet, ClassMetadata metadata, String[] searchPackages) throws IOException {
        if (metadata == null) {
            return null;
        }

        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassName(metadata.getDeclaredClass().getName());
        if (metadataSet.contains(metadata)) {
            List<ClassMetadata> componentClassMetadataList = metadata.getComponentClassMetadataList();
            if (componentClassMetadataList != null) {
                List<ClassInfo> componentClassList = new ArrayList<>(componentClassMetadataList.size());
                for (ClassMetadata componentClassMetadata : componentClassMetadataList) {
                    ClassInfo componentClassInfo = new ClassInfo();
                    componentClassInfo.setClassName(componentClassMetadata.getDeclaredClass().getName());
                    componentClassList.add(componentClassInfo);
                }
                classInfo.setComponentClassList(componentClassList);
            }
        } else {
            metadataSet.add(metadata);
            classInfo.setComponentClassList(getClassInfoList(metadataSet, metadata.getComponentClassMetadataList(), searchPackages));
            Set<ClassMetadata> implementClassMetadataSet = metadata.getImplementClassMetadataSet(searchPackages);
            if (implementClassMetadataSet != null) {
                classInfo.setImplementClassList(getClassInfoList(metadataSet, new ArrayList<>(implementClassMetadataSet), searchPackages));
            }
            classInfo.setConstructorList(getConstructorInfoList(metadataSet, metadata.getConstructorMetadataSet(), searchPackages));
            List originEnumValues = metadata.getEnumValues();
            if (originEnumValues != null) {
                List<String> enumValues = new ArrayList<>(originEnumValues.size());
                for (Object enumValue : originEnumValues) {
                    enumValues.add(enumValue.toString());
                }
                classInfo.setEnumValues(enumValues);
            }
        }
        return classInfo;
    }

    public static List<ConstructorInfo> getConstructorInfoList(Set<ClassMetadata> metadataSet, Set<ConstructorMetadata> constructorMetadataSet, String[] searchPackages) throws IOException {
        if (constructorMetadataSet == null) {
            return null;
        }
        List<ConstructorInfo> constructorInfoList = new ArrayList<>(constructorMetadataSet.size());
        for (ConstructorMetadata constructorMetadata : constructorMetadataSet) {
            constructorInfoList.add(getConstructorInfo(metadataSet, constructorMetadata, searchPackages));
        }
        return constructorInfoList;
    }

    public static ConstructorInfo getConstructorInfo(Set<ClassMetadata> metadataSet, ConstructorMetadata constructorMetadata, String[] searchPackages) throws IOException {
        if (constructorMetadata == null) {
            return null;
        }
        ConstructorInfo constructorInfo = new ConstructorInfo();
        Constructor constructor = constructorMetadata.getConstructor();
        constructorInfo.setClassName(constructor.getName());
        constructorInfo.setParamList(getClassInfoList(metadataSet, constructorMetadata.getParamList(), searchPackages));
        constructorInfo.setModifiers(constructor.getModifiers());
        constructorInfo.setIsAccessible(constructor.isAccessible());
        return constructorInfo;
    }

    public static MethodInfo getMethodInfo(Set<ClassMetadata> metadataSet, MethodMetadata methodMetadata, String[] searchPackages) throws IOException {
        if (methodMetadata == null) {
            return null;
        }
        MethodInfo methodInfo = new MethodInfo();
        Method method = methodMetadata.getDeclaredMethod();
        methodInfo.setClassName(method.getDeclaringClass().getName());
        methodInfo.setMethodName(method.getName());
        methodInfo.setParamList(getClassInfoList(metadataSet, methodMetadata.getParamList(), searchPackages));
        methodInfo.setModifiers(method.getModifiers());
        methodInfo.setIsAccessible(method.isAccessible());
        return methodInfo;
    }

    public static List<BeanMaterial> getBeanMaterialList(List<BeanCall> beanCall) throws ClassNotFoundException, NoSuchMethodException {
        if (beanCall == null) {
            return null;
        }
        List<BeanMaterial> beanMaterialList = new ArrayList<>(beanCall.size());
        for (BeanCall call : beanCall) {
            beanMaterialList.add(getBeanMaterial(call));
        }
        return beanMaterialList;
    }

    public static BeanMaterial getBeanMaterial(BeanCall beanCall) throws ClassNotFoundException, NoSuchMethodException {
        if (beanCall == null) {
            return null;
        }
        Class declaredClass = ClassUtils.forName(beanCall.getDeclaredClassName());
        Class actualClass = ClassUtils.forName(beanCall.getActualClassName());
        if (actualClass.isEnum()) {
            return new EnumMaterial(actualClass, beanCall.getBeanName(), beanCall.getBeanValue(), getMethodMaterial(beanCall.getMethod()));
        } else if (Collection.class.isAssignableFrom(actualClass) || actualClass.isArray()) {
            return new CollectionMaterial(declaredClass, actualClass,
                    beanCall.getBeanName(), beanCall.getBeanValue(),
                    getConstructorMaterial(beanCall.getConstructor()),
                    getMethodMaterial(beanCall.getMethod()),
                    getBeanMaterialList(beanCall.getCollectionComponents()));
        } else if (Map.class.isAssignableFrom(actualClass)) {
            List<List<BeanMaterial>> mapComponents = null;
            if (beanCall.getMapComponents() != null) {
                mapComponents = new ArrayList<>(beanCall.getMapComponents().size());
                for (List<BeanCall> beanCalls : beanCall.getMapComponents()) {
                    mapComponents.add(getBeanMaterialList(beanCalls));
                }
            }
            return new MapMaterial(declaredClass, actualClass,
                    beanCall.getBeanName(), beanCall.getBeanValue(),
                    getConstructorMaterial(beanCall.getConstructor()),
                    getMethodMaterial(beanCall.getMethod()),
                    mapComponents);
        } else {
            return new BeanMaterial(declaredClass, actualClass,
                    beanCall.getBeanName(), beanCall.getBeanValue(),
                    getConstructorMaterial(beanCall.getConstructor()),
                    getMethodMaterial(beanCall.getMethod()));
        }
    }

    public static ConstructorMaterial getConstructorMaterial(ConstructorCall constructorCall) throws ClassNotFoundException, NoSuchMethodException {
        if (constructorCall == null) {
            return null;
        }
        Class clazz = ClassUtils.forName(constructorCall.getClassName());
        List<BeanMaterial> paramList = getBeanMaterialList(constructorCall.getParamList() == null ? new ArrayList<>() : constructorCall.getParamList());
        return new ConstructorMaterial(clazz, paramList);
    }

    public static MethodMaterial getMethodMaterial(MethodCall methodCall) throws ClassNotFoundException, NoSuchMethodException {
        if (methodCall == null) {
            return null;
        }
        Class clazz = ClassUtils.forName(methodCall.getClassName());
        BeanMaterial invoker = getBeanMaterial(methodCall.getInvoker());
        List<BeanMaterial> paramList = getBeanMaterialList(methodCall.getParamList() == null ? new ArrayList<>() : methodCall.getParamList());
        return new MethodMaterial(clazz, invoker, methodCall.getMethodName(), paramList, methodCall.getReturnBeanName());
    }
}
