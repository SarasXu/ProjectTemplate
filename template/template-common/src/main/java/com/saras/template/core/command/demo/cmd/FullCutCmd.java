package com.saras.template.core.command.demo.cmd;

import com.saras.template.core.command.CommandChain;
import com.saras.template.core.command.demo.base.AbstractDiscountCommand;
import com.saras.template.core.command.demo.base.DiscountPriority;
import com.saras.template.core.strategy.demo.base.TestBiz;
import org.springframework.stereotype.Component;

/**
 * description:
 * saras_xu@163.com 2017-03-28 09:25 创建
 */
@Component
public class FullCutCmd extends AbstractDiscountCommand {

    @Override
    public void execute(TestBiz entity, CommandChain<TestBiz> chain) {
        System.out.println("执行满减优惠");
        entity.setType("fullCut");
        chain.proceed(entity);
    }

    public FullCutCmd() {
        setOrder(DiscountPriority.FULL_CUT);
    }
}
