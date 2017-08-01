package com.peknight.test;

import com.peknight.common.config.PekApplication;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;

@PekApplication
public class TestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

	public static void main(String[] args) {
		ApplicationContextHolder.run(TestApplication.class, args, Banner.Mode.LOG);
    }
}
