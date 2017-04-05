package com.saras.template;

import com.alibaba.dubbo.config.annotation.Service;
import com.saras.template.core.dubbo.DubboRemoteProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 * saras_xu@163.com 2017-04-05 13:40 创建
 */
@Service(version = "1.0")
public class TestFacadeImpl implements TestFacade {
    private final static Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);

    @Autowired
    private DubboRemoteProxyFactory dubboRemoteProxyFacotry;

    @Override
    public String test(String message) {
        logger.info("收到dubbo请求测试信息：{}", message);
        return "已收到";
    }

    @Override
    public String testAync(String message, String group, String version) {
        logger.info("收到dubbo请求测试信息：{}", message);
        TestNotifyFacade testNotifyFacade = dubboRemoteProxyFacotry.getProxy(TestNotifyFacade.class, group, version);
        String result = testNotifyFacade.notify("异步通知信息>19910309");
        logger.info("异步通知结果：{}", result);
        return "等待异步通知消息";
    }
}
