package com.saras.template.core.strategy.demo.strategy;

import com.saras.template.core.strategy.demo.base.AbstractRefundStrategy;
import com.saras.template.core.strategy.demo.base.StrategyType;
import com.saras.template.core.strategy.demo.base.TestBiz;
import org.springframework.stereotype.Component;

/**
 * description:
 * saras_xu@163.com 2017-03-28 13:37 创建
 */
@Component(value = StrategyType.SERVICE.INTEGRAL_REFUND_CUT)
public class IntegralStrategy extends AbstractRefundStrategy {

    @Override
    public TestBiz executionStrategy(TestBiz o) {
        System.out.println("执行积分减退款策略");
        o.setStatus(StrategyType.SERVICE.INTEGRAL_REFUND_CUT);
        return o;
    }
}
