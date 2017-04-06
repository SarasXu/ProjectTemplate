package com.saras.template.core.command.demo.base;

/**
 * description:优惠优先等级
 * saras_xu@163.com 2017-03-28 11:23 创建
 */
public class DiscountPriority {
    /**
     * 随机减
     */
    public final static int RANDOM_CUT = 0;
    /**
     * 积分减
     */
    public final static int INTEGRAL_CUT = 1;
    /**
     * 满减
     */
    public final static int FULL_CUT = 2;
    /**
     * 积分+满减
     */
    public final static int FULL_AND_INTEGRAL_CUT = 4;
    /**
     * 随机+积分
     */
    public final static int RANDOM_AND_INTEGRAL_CUT = 3;
}
