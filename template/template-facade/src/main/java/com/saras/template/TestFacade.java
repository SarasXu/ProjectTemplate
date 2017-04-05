package com.saras.template;

/**
 * description:
 * saras_xu@163.com 2017-04-05 13:39 创建
 */
public interface TestFacade {
    String test(String message);

    String testAync(String message, String group, String version);

}
