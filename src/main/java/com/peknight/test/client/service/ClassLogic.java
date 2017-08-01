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
public class ClassLogic extends AbstractInvokerLogic {

    @Override
    public void home() throws Exception {
        LOGGER.info("### CLASS METHOD ###");
        LOGGER.info("[HINT] Input Full Class Name");
        String className = rootLogic.input();
        List<MethodInfo> methodList = listMethod(className);
        MethodInfo methodInfo = selectMethod(methodList);
        if (methodInfo.getParamList().size() > 0) {
            LOGGER.info("### Set ParamList For {} ###", methodInfo.getMethodName());
            setParamList(methodInfo.getParamList());
        }
        invoke(className, methodInfo);
    }

    public List<MethodInfo> listMethod(String className) throws TException {
        List<MethodInfo> methodList = systemServiceClient.listClassMethods(className);
        LOGGER.info("### Class Method List ###");
        for (int i = 0; i < methodList.size(); i++) {
            LOGGER.info("#{} {}", i, methodList.get(i));
        }
        return methodList;
    }

    public void invoke(String className, MethodInfo methodInfo) throws TException {
        Object object = systemServiceClient.invokeClassMethod(className, methodInfo);
        LOGGER.info(StringUtils.toString(object));
    }
}
