package com.saras.template.core.strategy.demo;

import com.saras.template.core.strategy.demo.base.TestBiz;

/**
 * description:
 * saras_xu@163.com 2017-03-28 13:45 创建
 */
public interface RefundStrategyService {
    TestBiz doExecute(int id, TestBiz biz);
}
