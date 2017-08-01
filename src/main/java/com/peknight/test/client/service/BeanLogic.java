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
package com.peknight.test.client.service;

import com.peknight.common.logging.CommonLog;
import com.peknight.common.string.StringUtils;
import com.peknight.test.thrift.service.BeanInfo;
import com.peknight.test.thrift.service.MethodInfo;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
@CommonLog
@Component
public class BeanLogic extends AbstractInvokerLogic {
    public List<BeanInfo> listBeans() throws TException {
        List<BeanInfo> beanList = systemServiceClient.listBeans();
        LOGGER.info("### Bean List ###");
        int size = beanList.size();
        for (int i = 0; i < size; i++) {
            LOGGER.info("#{} {}", i, beanList.get(i));
        }
        return beanList;
    }

    public BeanInfo selectBean(List<BeanInfo> beanList) {
        LOGGER.info("[HINT] Input Bean Number");
        int index = Integer.parseInt(rootLogic.input());
        return beanList.get(index);
    }

    @Override
    public void home() throws Exception {
        List<BeanInfo> beanList = listBeans();
        BeanInfo beanInfo = selectBean(beanList);
        List<MethodInfo> methodList = listMethods(beanInfo);
        MethodInfo methodInfo = selectMethod(methodList);
        if (methodInfo.getParamList().size() > 0) {
            LOGGER.info("### Set ParamList For {} ###", methodInfo.getMethodName());
            setParamList(methodInfo.getParamList());
        }
        invoke(beanInfo, methodInfo);
    }

    public List<MethodInfo> listMethods(BeanInfo beanInfo) throws TException {
        List<MethodInfo> methodList = systemServiceClient.listBeanMethods(beanInfo);
        LOGGER.info("### Bean Method List ###");
        for (int i = 0; i < methodList.size(); i++) {
            LOGGER.info("#{} {}", i, methodList.get(i));
        }
        return methodList;
    }

    public void invoke(BeanInfo beanInfo, MethodInfo methodInfo) throws Exception {
        Object object = systemServiceClient.invokeBeanMethod(beanInfo, methodInfo);
        LOGGER.info(StringUtils.toString(object));
    }
}
