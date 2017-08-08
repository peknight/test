package com.peknight.test;

import com.peknight.common.config.PekApplication;
import com.peknight.common.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

@PekApplication
public class TestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestApplication.class);

	public static void main(String[] args) throws Exception {
//		ApplicationContextHolder.run(TestApplication.class, args, Banner.Mode.LOG);
		Level.class.getMethod("values").invoke(null);
		LOGGER.info(StringUtils.toString(Enum.valueOf(Level.class, "40")));
	}
}
