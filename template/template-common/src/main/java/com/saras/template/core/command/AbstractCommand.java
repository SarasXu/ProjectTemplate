package com.saras.template.core.command;

import org.springframework.core.Ordered;

/**
 * description:
 * saras_xu@163.com 2017-03-28 09:14 创建
 */
public abstract class AbstractCommand<R> implements Comparable<Ordered>, InterceptorCommand<R> {

    /**
     * 默认为最低处理级别
     */
    protected int order = LOWEST_PRECEDENCE;

    @Override
    public int getOrder() {
        if (order < 0) {
            order = HIGHEST_PRECEDENCE;//若赋予小于0的排序，那么则认为始终为最高级别。
        }
        return order;
    }

    @Override
    public boolean matcher(R receiveObject) {
        return Boolean.TRUE;
    }

    @Override
    public int compareTo(Ordered command) {
        return getOrder() > command.getOrder() ? 1 : getOrder() == command.getOrder() ? 0 : -1;
    }

    /**
     * 排序规则应当为正数。
     *
     * @param order 排序参数
     */
    @Override
    public void setOrder(int order) {
        this.order = order;
    }

}
