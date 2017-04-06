package com.saras.template.core.command;

import java.util.Iterator;

/**
 * description:
 * saras_xu@163.com 2017-03-28 10:14 创建
 */
public class FilterCommandChain<R> extends CommandChainBase<R> implements CommandChain<R> {
    /**
     * 采用iterator完成递归调用，该it存在状态，如果进行资源构建和释放，那
     * 么势必采用锁进行实现，所以这里采用从新生存实例解决该问题.
     */
    private Iterator<InterceptorInvocation<R>> commands;

    public FilterCommandChain(AbstractCommand<R>[] commands) {
        super(commands);
        this.commands = getCommands().iterator();
    }

    @Override
    public void proceed(R receiveObject) {
        if (commands.hasNext()) {
            InterceptorCommand<R> command = (InterceptorCommand<R>) commands.next();
            //和servlet过滤器基本类似，command内部必须调用CommandChain#proceed()方法.
            if (command.matcher(receiveObject)) {

                //处理
                command.execute(receiveObject, this);

            } else {
                proceed(receiveObject);
            }
        }
    }
}
