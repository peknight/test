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

import com.peknight.test.server.service.SystemServiceImpl;
import com.peknight.test.thrift.service.SystemService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
@Configuration
public class TestServerConfig {
    @Value("${test.server.port}")
    private int port;

    @Bean
    public SystemService.Iface systemServiceImpl() {
        return new SystemServiceImpl();
    }

    @Bean
    public TThreadedSelectorServer testTServer(SystemService.Iface systemService, @Value("${test.server.open}") boolean open) throws TTransportException {
        TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();
        multiplexedProcessor.registerProcessor("SystemService", new SystemService.Processor<>(systemService));
        TNonblockingServerTransport tNonblockingServerTransport = new TNonblockingServerSocket(port);
        TThreadedSelectorServer.Args tThreadedSelectorServerArgs = new TThreadedSelectorServer.Args(tNonblockingServerTransport);
        tThreadedSelectorServerArgs.processor(multiplexedProcessor);
        tThreadedSelectorServerArgs.transportFactory(new TFramedTransport.Factory());
        tThreadedSelectorServerArgs.protocolFactory(new TBinaryProtocol.Factory());
        TThreadedSelectorServer testTServer = new TThreadedSelectorServer(tThreadedSelectorServerArgs);
        if (open) {
            new Thread("TestServer") {
                @Override
                public void run() {
                    testTServer.serve();
                }
            }.start();
        }
        return testTServer;
    }
}
