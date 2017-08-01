package com.peknight.test.server;

import com.peknight.common.config.PekApplication;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import org.apache.thrift.server.TServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;

@PekApplication
public class TestServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestServerApplication.class);

	public static void main(String[] args) {
		ApplicationContextHolder.run(TestServerApplication.class, args, Banner.Mode.LOG);
		ApplicationContextHolder.getBean("testTServer", TServer.class).serve();
    }
}
