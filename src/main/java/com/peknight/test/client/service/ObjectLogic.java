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
import com.peknight.common.string.JsonUtils;
import com.peknight.common.string.StringUtils;
import com.peknight.test.thrift.service.ConstructorInfo;
import com.peknight.test.thrift.service.MethodInfo;
import com.peknight.test.thrift.service.ObjectInfo;
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
public class ObjectLogic extends AbstractInvokerLogic {
    @Override
    public void home() throws Exception {
        LOGGER.info("### Object Method ###");
        LOGGER.info("[HINT] Input Class Name");
        String className = rootLogic.input();
        ObjectInfo objectInfo = createObject(className);
        setObjectValue(objectInfo);
        List<MethodInfo> methodList = listMethods(objectInfo);
        MethodInfo methodInfo = selectMethod(methodList);
        if (methodInfo.getParamList().size() > 0) {
            LOGGER.info("### Set ParamList For {} ###", methodInfo.getMethodName());
            setParamList(methodInfo.getParamList());
        }
        invoke(objectInfo, methodInfo);
    }

    public ObjectInfo createObject(String className) throws TException {
        return systemServiceClient.createObject(className);
    }

    public void setObjectValue(ObjectInfo objectInfo) throws Exception {
        List<ConstructorInfo> constructorList = objectInfo.getConstructorList();
        int size = constructorList.size();
        if (size > 0) {
            LOGGER.info("## How To Set Value For The Object({})?", objectInfo.getType());
            LOGGER.info("#0 Set Value Directly");
            for (int i = 1; i <= constructorList.size(); i++) {
                LOGGER.info("#{} Set Constructor: {}", i, constructorList.get(i-1));
            }

            int index = Integer.parseInt(rootLogic.input());
            if (index != 0) {
                LOGGER.info("## Use Constructor[{}] For The Object, Please Set Constructor ParamList", index);
                ConstructorInfo constructorInfo = constructorList.get(index - 1);
                constructorList.clear();
                constructorList.add(constructorInfo);
                setParamList(constructorInfo.getParamList());
                return;
            } else {
                constructorList.clear();
            }
        }
        LOGGER.info("[HINT] Set Value Directly For The Object({})", objectInfo.getType());
        objectInfo.setValue(JsonUtils.write(rootLogic.input()));
        constructorList.clear();
    }

    public List<MethodInfo> listMethods(ObjectInfo objectInfo) throws TException {
        List<MethodInfo> methodList = systemServiceClient.listObjectMethods(objectInfo);
        LOGGER.info("### Object Method List ###");
        for (int i = 0; i < methodList.size(); i++) {
            LOGGER.info("#{} {}", i, methodList.get(i));
        }
        return methodList;
    }

    public void invoke(ObjectInfo objectInfo, MethodInfo methodInfo) throws Exception {
        Object object = systemServiceClient.invokeObjectMethod(objectInfo, methodInfo);
        LOGGER.info(StringUtils.toString(object));
    }
}
