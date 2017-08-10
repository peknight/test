package com.peknight.test.server;

import com.peknight.common.config.PekApplication;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import com.peknight.test.server.config.EnablePekTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;

@EnablePekTest
@PekApplication
public class PekTestServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PekTestServerApplication.class);

	public static void main(String[] args) {
		ApplicationContextHolder.run(PekTestServerApplication.class, args, Banner.Mode.LOG);
	}
}
