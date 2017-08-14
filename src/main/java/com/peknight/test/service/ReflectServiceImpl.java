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
package com.peknight.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peknight.common.collection.ArrayUtils;
import com.peknight.common.logging.CommonLog;
import com.peknight.common.reflect.material.BeanContext;
import com.peknight.common.reflect.material.BeanCreationException;
import com.peknight.common.reflect.material.BeanMaterial;
import com.peknight.common.reflect.material.MethodMaterial;
import com.peknight.common.reflect.metadata.MetadataContext;
import com.peknight.common.reflect.metadata.MethodMetadata;
import com.peknight.common.reflect.util.ClassUtils;
import com.peknight.common.reflect.util.MethodUtils;
import com.peknight.common.string.JsonUtils;
import com.peknight.common.string.StringUtils;
import com.peknight.test.thrift.reflect.ActionResult;
import com.peknight.test.thrift.reflect.ActionStatus;
import com.peknight.test.thrift.reflect.BeanCall;
import com.peknight.test.thrift.reflect.ClassInfo;
import com.peknight.test.thrift.reflect.MethodCall;
import com.peknight.test.thrift.reflect.MethodInfo;
import com.peknight.test.thrift.reflect.ReflectService;
import com.peknight.test.util.ConvertUtils;
import org.apache.thrift.TException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 反射服务实现类
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/8/10.
 */
@CommonLog
public class ReflectServiceImpl implements ReflectService.Iface {

    @Override
    public ClassInfo getClassInfo(String className, List<String> searchPackages) throws TException {
        String[] searchPackageArray = null;
        if (searchPackages != null) {
            searchPackageArray = ArrayUtils.collectionToArray(searchPackages, new String[searchPackages.size()]);
        }
        try {
            return ConvertUtils.getClassInfo(new HashSet<>(), MetadataContext.getClassMetadata(ClassUtils.forName(className)), searchPackageArray);
        } catch (IOException e) {
            throw new TException(e);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public List<ClassInfo> listClassInfo(List<String> basePackages, List<String> searchPackages) throws TException {
        String[] searchPackageArray = null;
        if (searchPackages != null) {
            searchPackageArray = ArrayUtils.collectionToArray(searchPackages, new String[searchPackages.size()]);
        }
        List<ClassInfo> classInfoList = new ArrayList<>();
        try {
            Set<Class> classSet = ClassUtils.listClass(ArrayUtils.collectionToArray(basePackages, new String[basePackages.size()]));
            for (Class clazz : classSet) {
                classInfoList.add(ConvertUtils.getClassInfo(new HashSet<>(), MetadataContext.getClassMetadata(clazz), searchPackageArray));
            }
            return classInfoList;
        } catch (IOException e) {
            throw new TException(e);
        }
    }

    @Override
    public MethodInfo getMethodInfo(String className, String methodName, List<String> paramList, List<String> searchPackages) throws TException {
        String[] searchPackageArray = null;
        if (searchPackages != null) {
            searchPackageArray = ArrayUtils.collectionToArray(searchPackages, new String[searchPackages.size()]);
        }
        try {
            Class clazz = ClassUtils.forName(className);
            Class[] parameterTypes = MethodUtils.getParameterTypesByClassNames(paramList);
            Method method = MethodUtils.getMethod(clazz, methodName, parameterTypes);
            return ConvertUtils.getMethodInfo(new HashSet<>(), MetadataContext.getMethodMetadata(method), searchPackageArray);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        } catch (NoSuchMethodException e) {
            throw new TException(e);
        } catch (IOException e) {
            throw new TException(e);
        }
    }

    @Override
    public List<MethodInfo> listMethodInfo(String className, List<String> searchPackages) throws TException {
        String[] searchPackageArray = null;
        if (searchPackages != null) {
            searchPackageArray = ArrayUtils.collectionToArray(searchPackages, new String[searchPackages.size()]);
        }
        List<MethodInfo> methodInfoList = new ArrayList<>();
        try {
            Class clazz = ClassUtils.forName(className);
            for (MethodMetadata methodMetadata : MethodUtils.getMethodSet(clazz)) {
                methodInfoList.add(ConvertUtils.getMethodInfo(new HashSet<>(), methodMetadata, searchPackageArray));
            }
            return methodInfoList;
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        } catch (IOException e) {
            throw new TException(e);
        }
    }

    @Override
    public List<BeanCall> listBean() throws TException {
        List<String> keys = BeanContext.listKey();
        List<BeanCall> beanList = new ArrayList<>(keys.size());
        for (String key : keys) {
            Object object = BeanContext.get(key);
            String className = object.getClass().getName();
            BeanCall beanCall = new BeanCall();
            beanCall.setDeclaredClassName(className);
            beanCall.setActualClassName(className);
            beanCall.setBeanName(key);
            try {
                beanCall.setBeanValue(JsonUtils.write(object));
            } catch (JsonProcessingException e) {}
            beanList.add(beanCall);
        }
        return beanList;
    }

    @Override
    public ActionResult createBean(BeanCall beanCall) throws TException {
        try {
            BeanMaterial beanMaterial = ConvertUtils.getBeanMaterial(beanCall);
            String value = null;
            try {
                value = JsonUtils.write(beanMaterial.getBean());
            } catch (JsonProcessingException e) {}
            return new ActionResult(ActionStatus.Success, "Success", value);
        } catch (ClassNotFoundException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (NoSuchMethodException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (BeanCreationException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        }
    }

    @Override
    public ActionResult invokeMethod(MethodCall methodCall) throws TException {
        try {
            MethodMaterial methodMaterial = ConvertUtils.getMethodMaterial(methodCall);
            methodMaterial.invokeMethod();
            Object returnValue = methodMaterial.getReturnValue();
            return new ActionResult(ActionStatus.Success, "Success", StringUtils.toString(returnValue));
        } catch (ClassNotFoundException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (NoSuchMethodException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IllegalAccessException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InvocationTargetException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (BeanCreationException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        }
    }
}
