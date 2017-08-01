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

import com.peknight.common.string.JsonUtils;
import com.peknight.test.thrift.service.ConstructorInfo;
import com.peknight.test.thrift.service.MethodInfo;
import com.peknight.test.thrift.service.ObjectInfo;
import com.peknight.test.thrift.service.SystemService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/8/1.
 */
public abstract class AbstractInvokerLogic implements InvokeService {

    @Resource
    protected RootLogic rootLogic;

    @Resource
    protected Scanner scanner;

    @Resource
    protected SystemService.Iface systemServiceClient;

    @Override
    public void parseCustomInput(String input) {
    }

    @Override
    public void exit() {
        rootLogic.exit();
    }

    @Override
    public void currentInfo() {
    }

    @Override
    public MethodInfo selectMethod(List<MethodInfo> methodList) {
        LOGGER.info("[HINT] Select Method Number");
        String input = rootLogic.input();
        try {
            int index = Integer.parseInt(input);
            return methodList.get(index);
        } catch (NumberFormatException e) {
            LOGGER.error("Number Format Exception: {}", e.toString(), e);
            throw e;
        }
    }

    @Override
    public void setParamList(List<ObjectInfo> paramList) throws Exception {
        for (int i = 0; i < paramList.size(); i++) {
            ObjectInfo objectInfo = paramList.get(i);
            List<ConstructorInfo> constructorList = objectInfo.getConstructorList();
            int size = constructorList.size();
            if (size > 0) {
                LOGGER.info("## How To Set Value For Param{}({})?", i, objectInfo.getType());
                LOGGER.info("#0 Set Value Directly");
                for (int j = 1; j <= constructorList.size(); j++) {
                    LOGGER.info("#{} Set Constructor: {}", j, constructorList.get(j-1));
                }

                int index = Integer.parseInt(rootLogic.input());
                if (index != 0) {
                    LOGGER.info("## Use Constructor[{}] For Param{}, Please Set Constructor ParamList", index, i);
                    ConstructorInfo constructorInfo = constructorList.get(index - 1);
                    constructorList.clear();
                    constructorList.add(constructorInfo);
                    setParamList(constructorInfo.getParamList());
                    return;
                } else {
                    constructorList.clear();
                }
            }
            LOGGER.info("[HINT] Set Value Directly For Param{}({})", i, objectInfo.getType());
            objectInfo.setValue(JsonUtils.write(rootLogic.input()));
            constructorList.clear();
        }
    }
}
