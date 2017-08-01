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
package com.peknight.test.server.service;

import com.peknight.common.logging.CommonLog;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import com.peknight.common.string.JsonUtils;
import com.peknight.test.thrift.service.ActionResult;
import com.peknight.test.thrift.service.ActionStatus;
import com.peknight.test.thrift.service.BeanInfo;
import com.peknight.test.thrift.service.MethodInfo;
import com.peknight.test.thrift.service.ObjectInfo;
import com.peknight.test.thrift.service.SystemService;
import com.peknight.test.util.ReflectUtils;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SystemService实现
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
@CommonLog
public class SystemServiceImpl implements SystemService.Iface {

    public static final Set<String> DEFAULT_BEAN_NAMES = new HashSet<>();

    static {
        DEFAULT_BEAN_NAMES.add("objectNamingStrategy");
        DEFAULT_BEAN_NAMES.add("propertySourcesPlaceholderConfigurer");
    }

    @Override
    public List<BeanInfo> listBeans() throws TException {
        String[] beanNames = ApplicationContextHolder.getApplicationContext().getBeanDefinitionNames();
        List<BeanInfo> beanList = new ArrayList<>();
        for (String beanName : beanNames) {
            if (beanName.indexOf(".") != -1 || beanName.startsWith("mbean")
                    || DEFAULT_BEAN_NAMES.contains(beanName)) {
                continue;
            } else {
                String type = ApplicationContextHolder.getBean(beanName).getClass().getName();
//                type = type.substring(0, type.indexOf("$"));
                beanList.add(new BeanInfo(type, beanName));
            }
        }
        return beanList;
    }

    @Override
    public List<MethodInfo> listBeanMethods(BeanInfo beanInfo) throws TException {
        try {
            Object object = ReflectUtils.parseBean(beanInfo);
            return ReflectUtils.getMethodList(object.getClass(), false);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public ObjectInfo createObject(String className) throws TException {
        try {
            Class clazz = ReflectUtils.forName(className);
            return ReflectUtils.createObjectInfo(clazz);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public List<MethodInfo> listObjectMethods(ObjectInfo objectInfo) throws TException {
        try {
            return ReflectUtils.getMethodList(ReflectUtils.forName(objectInfo.getType()), false);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public List<MethodInfo> listClassMethods(String className) throws TException {
        try {
            Class<?> clazz = ReflectUtils.forName(className);
            return ReflectUtils.getMethodList(clazz, true);
        } catch (ClassNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public ActionResult invokeBeanMethod(BeanInfo beanInfo, MethodInfo methodInfo) throws TException {
        try {
            Object returnValue =  ReflectUtils.invokeBeanMethod(beanInfo, methodInfo);
            return new ActionResult(ActionStatus.Success, "Success", JsonUtils.write(returnValue));
        } catch (ClassNotFoundException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (NoSuchMethodException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InvocationTargetException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InstantiationException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IllegalAccessException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IOException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        }
    }

    @Override
    public ActionResult invokeObjectMethod(ObjectInfo objectInfo, MethodInfo methodInfo) throws TException {
        try {
            Object returnValue =  ReflectUtils.invokeObjectMethod(objectInfo, methodInfo);
            return new ActionResult(ActionStatus.Success, "Success", JsonUtils.write(returnValue));
        } catch (ClassNotFoundException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (NoSuchMethodException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InvocationTargetException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InstantiationException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IllegalAccessException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IOException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        }
    }

    @Override
    public ActionResult invokeClassMethod(String className, MethodInfo methodInfo) throws TException {
        try {
            Object returnValue =  ReflectUtils.invokeClassMethod(className, methodInfo);
            return new ActionResult(ActionStatus.Success, "Success", JsonUtils.write(returnValue));
        } catch (ClassNotFoundException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (NoSuchMethodException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InvocationTargetException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (InstantiationException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IllegalAccessException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        } catch (IOException e) {
            return new ActionResult(ActionStatus.Fail, e.getMessage(), null);
        }
    }

    @Override
    public ActionResult startService(String serviceName) throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult pauseService(String serviceName) throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult restartService(String serviceName) throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult shutService(String serviceName) throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult initEnvironment() throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult initDevEnvironment() throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult restoreEnvironment() throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult restoreDevEnvironment() throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }

    @Override
    public ActionResult shutdown() throws TException {
        return new ActionResult(ActionStatus.Fail, "Not Supported Yet", null);
    }
}
