package com.saras.template.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.*;

/**
 * description:
 * saras_xu@163.com 2017-03-10 10:28 创建
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
public @interface AppBoot {
    /**
     * 环境名称
     */
    String env() default "local";

    /**
     * httpPort 默认8080
     */
    int port() default 8080;
}
