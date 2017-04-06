package com.saras.template.core.strategy.demo.impl;

import com.google.common.collect.Maps;
import com.saras.template.core.strategy.Strategy;
import com.saras.template.core.strategy.demo.RefundStrategyService;
import com.saras.template.core.strategy.demo.base.StrategyType;
import com.saras.template.core.strategy.demo.base.TestBiz;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * description:
 * saras_xu@163.com 2017-03-28 13:46 创建
 */
@Service
public class RefundStrategyServiceImpl implements InitializingBean, ApplicationContextAware, RefundStrategyService {

    private ApplicationContext applicationContext;

    private Map<String, Strategy> strategyMap = Maps.newHashMap();


    @Override
    public void afterPropertiesSet() throws Exception {
        strategyMap = applicationContext.getBeansOfType(Strategy.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    @SuppressWarnings("unchecked")
    public TestBiz doExecute(int id, TestBiz biz) {
        return (TestBiz) strategyMap.get(StrategyType.SERVICE.getStrategy(id)).executionStrategy(biz);
    }
}
