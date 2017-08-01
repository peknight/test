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
import org.apache.thrift.transport.TTransport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;

/**
 *
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
@CommonLog
@Component
public class RootLogic implements GlobalService {

    private static final String SESSION = "ROOT";

    public static final String BEAN = "$b";
    public static final String CLASS = "$c";
    public static final String OBJECT = "$o";
    public static final String SYSTEM = "$s";

    @Resource
    private TTransport clientTTransport;

    @Resource
    private Scanner scanner;

    @Resource
    private SystemLogic systemLogic;

    @Resource
    private BeanLogic beanLogic;

    @Resource
    private ClassLogic classLogic;

    @Resource
    private ObjectLogic objectLogic;

    public String input() {
        String input = scanner.next();
        LOGGER.info("# INPUT # {}", input);
        return input;
    }

    @Override
    public void parseCustomInput(String input) throws Exception {
        switch (input) {
            case BEAN:
                beanLogic.home();
                break;
            case CLASS:
                classLogic.home();
                break;
            case OBJECT:
                objectLogic.home();
                break;
            case SYSTEM:
                systemLogic.home();
                break;
            default:
                LOGGER.info("No Such Option: {}, Input '{}' For Information", input, INFO);
                break;
        }
    }

    @Override
    public void exit() {
        clientTTransport.close();
        scanner.close();
        System.exit(0);
    }

    @Override
    public void currentInfo() {
        LOGGER.info("[HINT] # ROOT　INFO #");
        LOGGER.info("[HINT] Input '{}' -> Invoke Method With A Spring Bean", BEAN);
        LOGGER.info("[HINT] Input '{}' -> Invoke A static method", CLASS);
        LOGGER.info("[HINT] Input '{}' -> Invoke method with A Custom Object", OBJECT);
        LOGGER.info("[HINT] Input '{}' -> Invoke A System Method", SYSTEM);
    }

    @Override
    public void home() throws Exception {
        SESSION_ID.set(SESSION);
        while (SESSION.equals(SESSION_ID.get())) {
            info();
            parseInput(input());
        }
    }
}
