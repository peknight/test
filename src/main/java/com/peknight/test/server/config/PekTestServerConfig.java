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
package com.peknight.test.server.config;

import com.peknight.test.service.ReflectServiceImpl;
import com.peknight.test.thrift.reflect.ReflectService;
import com.peknight.test.thrift.service.MessageService;
import com.peknight.test.thrift.service.SystemService;
import org.apache.thrift.TException;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

import java.net.InetSocketAddress;

/**
 *
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/8/10.
 */
@Conditional(PekTestEnable.class)
public class PekTestServerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(PekTestServerConfig.class);

    @Bean
    public ReflectService.Iface reflectServiceImpl() {
        return new ReflectServiceImpl();
    }

    @Conditional(SystemServiceCondition.class)
    @Bean
    public SystemService.Iface systemServiceImpl() {
        return new SystemService.Iface() {
            @Override
            public void startService(String serviceName, long millis) throws TException {}
            @Override
            public void pauseService(String serviceName, long millis) throws TException {}
            @Override
            public void restartService(String serviceName, long millis) throws TException {}
            @Override
            public void stopService(String serviceName, long millis) throws TException {}
            @Override
            public void initEnvironment(String serviceName, long millis) throws TException {}
            @Override
            public void initDevelopment(String serviceName, long millis) throws TException {}
            @Override
            public void restoreEnvironment(String serviceName, long millis) throws TException {}
            @Override
            public void restoreDevelopment(String serviceName, long millis) throws TException {}
            @Override
            public void shutdown(long millis) throws TException {}
        };
    }

    @Bean
    public TThreadedSelectorServer pekTestTServer(Environment environment, ReflectService.Iface reflectServiceImpl, MessageService.Iface messageServiceImpl, SystemService.Iface systemServiceImpl) throws TTransportException {
        TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();
        multiplexedProcessor.registerProcessor("ReflectService", new ReflectService.Processor<>(reflectServiceImpl));
        multiplexedProcessor.registerProcessor("MessageService", new MessageService.Processor<>(messageServiceImpl));
        multiplexedProcessor.registerProcessor("SystemService", new SystemService.Processor<>(systemServiceImpl));

        TNonblockingServerTransport tNonblockingServerTransport;
        String address = environment.getProperty("test.client.address");
        String portString = environment.getProperty("test.server.port");
        int port = portString == null ? 6712 : Integer.parseInt(portString);
        if (address == null) {
            tNonblockingServerTransport = new TNonblockingServerSocket(port);
        } else {
            tNonblockingServerTransport = new TNonblockingServerSocket(new InetSocketAddress(address, port));
        }

        TThreadedSelectorServer.Args tThreadedSelectorServerArgs = new TThreadedSelectorServer.Args(tNonblockingServerTransport);
        tThreadedSelectorServerArgs.processor(multiplexedProcessor);
        tThreadedSelectorServerArgs.transportFactory(new TFramedTransport.Factory());
        tThreadedSelectorServerArgs.protocolFactory(new TBinaryProtocol.Factory());
        TThreadedSelectorServer pekTestTServer = new TThreadedSelectorServer(tThreadedSelectorServerArgs);
        new Thread("PekTestServer") {
            @Override
            public void run() {
                pekTestTServer.serve();
            }
        }.start();
        LOGGER.info("Pek Test Server Start Successfully");
        return pekTestTServer;
    }
}
