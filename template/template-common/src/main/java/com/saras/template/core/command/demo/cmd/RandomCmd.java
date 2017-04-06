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
public class RandomCmd extends AbstractDiscountCommand {

    @Override
    public void execute(TestBiz entity, CommandChain<TestBiz> chain) {
        System.out.println("执行随机减优惠");
        entity.setType("random");
        chain.proceed(entity);
    }

    //
    public RandomCmd() {
        setOrder(DiscountPriority.RANDOM_CUT);
    }
}
