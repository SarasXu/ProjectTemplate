package com.saras.template.core.command.demo.impl;

import com.google.common.collect.Lists;
import com.saras.template.core.command.demo.DiscountService;
import com.saras.template.core.command.demo.base.AbstractDiscountCommand;
import com.saras.template.core.command.demo.base.DiscountProcessorCommandChain;
import com.saras.template.core.strategy.demo.base.TestBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description:
 * saras_xu@163.com 2017-03-28 09:47 创建
 */
@Service
public class DiscountServiceImpl implements InitializingBean, ApplicationContextAware, DiscountService {
    private final static Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);

    private ApplicationContext applicationContext;

    private List<AbstractDiscountCommand> cmds = Lists.newArrayList();

    @Override
    public void afterPropertiesSet() throws Exception {
        //从spring容器获取 AbstractDiscountCommand 子类bean
        Map<String, AbstractDiscountCommand> cmdMap = applicationContext
                .getBeansOfType(AbstractDiscountCommand.class);

        for (Map.Entry<String, AbstractDiscountCommand> entry : cmdMap.entrySet()) {
            cmds.add(entry.getValue());
        }
        logger.debug("demo执行命令个数:" + cmds.size());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public TestBiz doBiz() {
        TestBiz testBiz = new TestBiz();
        new DiscountProcessorCommandChain(
                cmds.toArray(new AbstractDiscountCommand[cmds.size()])).proceed(testBiz);
        return testBiz;

    }
}
