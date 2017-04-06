package com.saras.template.core.command.demo.base;


import com.saras.template.core.command.AbstractCommand;
import com.saras.template.core.command.FilterCommandChain;
import com.saras.template.core.strategy.demo.base.TestBiz;

/**
 * description:
 * saras_xu@163.com 2017-03-28 10:13 创建
 */
public class DiscountProcessorCommandChain extends FilterCommandChain<TestBiz> {

    public DiscountProcessorCommandChain(AbstractCommand<TestBiz>[] commands) {
        super(commands);
    }
}
