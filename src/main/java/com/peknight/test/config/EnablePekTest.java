package com.peknight.test.config;

import com.peknight.common.springframework.context.ApplicationContextHolder;
import com.peknight.test.service.MessageServiceImpl;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author PeKnight
 *
 * Created by PeKnight on 2017/8/1.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import({PekTestServerConfig.class, MessageServiceImpl.class, ApplicationContextHolder.class})
public @interface EnablePekTest {
}
