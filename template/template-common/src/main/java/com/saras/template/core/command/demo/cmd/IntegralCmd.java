package com.saras.template.core.command.demo.cmd;

import com.saras.template.core.command.CommandChain;
import com.saras.template.core.command.demo.base.AbstractDiscountCommand;
import com.saras.template.core.command.demo.base.DiscountPriority;
import com.saras.template.core.strategy.demo.base.TestBiz;
import org.springframework.stereotype.Component;

/**
 * description:
 * saras_xu@163.com 2017-03-28 09:26 创建
 */
@Component
public class IntegralCmd extends AbstractDiscountCommand {

    @Override
    public void execute(TestBiz entity, CommandChain<TestBiz> chain) {
        System.out.println("执行积分优惠");
        entity.setType("integral");
        chain.proceed(entity);
    }

    public IntegralCmd() {
        setOrder(DiscountPriority.INTEGRAL_CUT);
    }
}
