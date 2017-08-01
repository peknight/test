package com.peknight.test.client;

import com.peknight.common.config.PekApplication;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import com.peknight.test.client.service.RootLogic;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;

import javax.annotation.Resource;

@PekApplication
public class TestClientApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestClientApplication.class);

	@Resource
    private TTransport clientTTransport;

	@Resource
    private RootLogic rootLogic;

	public void startClient() throws Exception {
        clientTTransport.open();
        rootLogic.home();
        clientTTransport.close();
    }

	public static void main(String[] args) throws Exception {
		ApplicationContextHolder.run(TestClientApplication.class, args, Banner.Mode.LOG);
		ApplicationContextHolder.getBean(TestClientApplication.class).startClient();
    }
}
