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

import com.peknight.common.collection.ArrayUtils;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import com.peknight.common.string.JsonUtils;
import com.peknight.common.string.StringUtils;
import com.peknight.test.thrift.service.ActionResult;
import com.peknight.test.thrift.service.ActionStatus;
import com.peknight.test.thrift.service.BeanInfo;
import com.peknight.test.thrift.service.ConstructorInfo;
import com.peknight.test.thrift.service.MethodInfo;
import com.peknight.test.thrift.service.ObjectInfo;
import com.peknight.test.thrift.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 测试 - 反射操作工具类
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
public final class ReflectUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtils.class);

    private ReflectUtils() {}

    public static final Set<String> DEFAULT_METHOD_NAMES = new HashSet<>();

    public static final Set<Class> IGNORE_CLASS = new HashSet<>();

    static {
        DEFAULT_METHOD_NAMES.add("wait");
        DEFAULT_METHOD_NAMES.add("equals");
        DEFAULT_METHOD_NAMES.add("toString");
        DEFAULT_METHOD_NAMES.add("hashCode");
        DEFAULT_METHOD_NAMES.add("getClass");
        DEFAULT_METHOD_NAMES.add("notify");
        DEFAULT_METHOD_NAMES.add("notifyAll");
        IGNORE_CLASS.add(Integer.class);
        IGNORE_CLASS.add(Long.class);
        IGNORE_CLASS.add(Byte.class);
        IGNORE_CLASS.add(Short.class);
        IGNORE_CLASS.add(Character.class);
        IGNORE_CLASS.add(Float.class);
        IGNORE_CLASS.add(Double.class);
        IGNORE_CLASS.add(Boolean.class);
        IGNORE_CLASS.add(int.class);
        IGNORE_CLASS.add(long.class);
        IGNORE_CLASS.add(byte.class);
        IGNORE_CLASS.add(short.class);
        IGNORE_CLASS.add(char.class);
        IGNORE_CLASS.add(float.class);
        IGNORE_CLASS.add(double.class);
        IGNORE_CLASS.add(boolean.class);
        IGNORE_CLASS.add(String.class);
    }

    public static Class<?> forName(String className) throws ClassNotFoundException {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class Not Found: {}", className, e);
            throw e;
        }
    }

    public static Method parseMethod(Class<?> clazz, String methodName, Class[] paramtertypes) throws NoSuchMethodException {
        try {
            return clazz.getMethod(methodName, paramtertypes);
        } catch (NoSuchMethodException e) {
            LOGGER.error("No Such Method: {}", methodName, e);
            throw e;
        }
    }

    public static Class[] parseParamterTypes(List<ObjectInfo> paramList) throws ClassNotFoundException {
        int length = paramList.size();
        Class[] paramterTypes = new Class[length];
        for (int i = 0; i < length; i++) {
            paramterTypes[i] = forName(paramList.get(i).getType());
        }
        return paramterTypes;
    }

    public static Object parseBean(BeanInfo beanInfo) throws ClassNotFoundException {
        Class<?> clazz = forName(beanInfo.getType());
        return ApplicationContextHolder.getBean(beanInfo.getBeanName(), clazz);
    }

    public static Object parseObject(ObjectInfo objectInfo) throws ClassNotFoundException, IOException {
        Class<?> clazz = forName(objectInfo.getType());
        if (!StringUtils.isEmpty(objectInfo.getValue())) {
            try {
                return JsonUtils.read(objectInfo.getValue(), clazz);
            } catch (IOException e) {
                return invokeConstructor(clazz, objectInfo.getConstructorList());
            }
        } else {
            return invokeConstructor(clazz, objectInfo.getConstructorList());
        }
    }

    public static Object[] parseArgs(List<ObjectInfo> paramList) throws ClassNotFoundException, IOException,
            NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        int length = paramList.size();
        Object[] args = new Object[length];
        for (int i = 0; i < length; i++) {
            args[i] = parseObject(paramList.get(i));
        }
        return args;
    }

    public static Object invokeConstructor(Class<?> clazz, List<ConstructorInfo> constructorList)
            throws ClassNotFoundException, IOException {
        for (ConstructorInfo constructorInfo : constructorList) {
            try {
                Constructor constructor = clazz.getConstructor(parseParamterTypes(constructorInfo.getParamList()));
                return constructor.newInstance(parseArgs(constructorInfo.getParamList()));
            } catch (NoSuchMethodException e) {
                LOGGER.error("No Such Method: ({}) {}", clazz, constructorInfo, e);
            } catch (IllegalAccessException e) {
                LOGGER.error("Illegal Access: ({}) {}", clazz, constructorInfo, e);
            } catch (InstantiationException e) {
                LOGGER.error("Instantiation: ({}) {}", clazz, constructorInfo, e);
            } catch (InvocationTargetException e) {
                LOGGER.error("Invocation Target: ({}) {}", clazz, constructorInfo, e);
            }
        }
        LOGGER.error("Parse Param Constructor Failed: {}", clazz);
        throw new IllegalArgumentException("Parse Param Constructor Failed: " + clazz);
    }

    public static Object invokeMethod(Object invokeObject, Method method, Object... args) throws IllegalAccessException,
            InvocationTargetException {
        try {
            return method.invoke(invokeObject, args);
        } catch (IllegalAccessException e) {
            LOGGER.error("Illegal Access: {}({}, {})", method.getName(), invokeObject, args);
            throw e;
        } catch (InvocationTargetException e) {
            LOGGER.error("Invocation Target: {}({}, {})", method.getName(), invokeObject, args);
            throw e;
        }
    }

    public static Object invokeBeanMethod(BeanInfo beanInfo, MethodInfo methodInfo) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException,
            IOException {
        Object invokeObject = parseBean(beanInfo);
        Class[] parameterTypes = parseParamterTypes(methodInfo.getParamList());
        Method method = parseMethod(forName(beanInfo.getType()), methodInfo.getMethodName(), parameterTypes);
        Object[] args = parseArgs(methodInfo.getParamList());
        return invokeMethod(invokeObject, method, args);
    }

    public static Object invokeObjectMethod(ObjectInfo objectInfo, MethodInfo methodInfo) throws IOException,
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Object invokeObject = parseObject(objectInfo);
        Class[] parameterTypes = parseParamterTypes(methodInfo.getParamList());
        Method method = parseMethod(forName(objectInfo.getType()), methodInfo.getMethodName(), parameterTypes);
        Object[] args = parseArgs(methodInfo.getParamList());
        return invokeMethod(invokeObject, method, args);
    }

    public static Object invokeClassMethod(String className, MethodInfo methodInfo) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException,
            IOException {
        Class[] parameterTypes = parseParamterTypes(methodInfo.getParamList());
        Method method = parseMethod(forName(className), methodInfo.getMethodName(), parameterTypes);
        Object[] args = parseArgs(methodInfo.getParamList());
        return invokeMethod(null, method, args);
    }

    public static ObjectInfo createObjectInfo(Class<?> clazz) {
        ObjectInfo objectInfo = new ObjectInfo();
        List<ConstructorInfo> constructorList = new ArrayList<>();
        if (!IGNORE_CLASS.contains(clazz) && !clazz.isArray()) {
            for (Constructor constructor : clazz.getConstructors()) {
                if (!ArrayUtils.contains(clazz, constructor.getParameterTypes())) {
                    constructorList.add(new ConstructorInfo(getParamList(constructor.getParameterTypes())));
                }
            }
        }
        objectInfo.setType(clazz.getName());
        objectInfo.setConstructorList(constructorList);
        return objectInfo;
    }

    public static List<ObjectInfo> getParamList(Class[] parameterTypes) {
        List<ObjectInfo> paramList = new ArrayList<>();
        for (Class parameterType : parameterTypes) {
            paramList.add(createObjectInfo(parameterType));
        }
        return paramList;
    }

    public static List<MethodInfo> getMethodList(Class<?> clazz, boolean isStatic) {
        List<MethodInfo> methodList = new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (DEFAULT_METHOD_NAMES.contains(method.getName()) || (Modifier.isStatic(method.getModifiers()) != isStatic)) {
                continue;
            } else {
                methodList.add(new MethodInfo(method.getName(), getParamList(method.getParameterTypes())));
            }
        }
        return methodList;
    }
}
