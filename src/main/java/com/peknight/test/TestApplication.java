package com.peknight.test;

import com.peknight.common.config.PekApplication;
import com.peknight.common.springframework.context.ApplicationContextHolder;
import org.springframework.boot.Banner;

@PekApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContextHolder.run(TestApplication.class, args, Banner.Mode.LOG);
	}
}
