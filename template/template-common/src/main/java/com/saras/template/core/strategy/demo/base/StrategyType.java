package com.saras.template.core.strategy.demo.base;

/**
 * description:
 * saras_xu@163.com 2017-03-28 14:09 创建
 */
public class StrategyType {
    /**
     * 服务名称
     */
    public final static class SERVICE {

        //id 对应 Constants的discountType
        /**
         * 满减退款策略
         */
        public final static String FULL_REFUND_CUT = "FULL_REFUND_CUT";

        /**
         * 积分减退款策略
         */
        public final static String INTEGRAL_REFUND_CUT = "INTEGRAL_REFUND_CUT";
        /**
         * 改单减退款策略
         */
        public final static String CHANGE_ORDER_REFUND_CUT = "CHANGE_ORDER_REFUND_CUT";

        /**
         * 随机减退款策略
         */
        public final static String RANDOM_CUT_REFUND = "RANDOM_CUT_REFUND";
        /**
         * 无优惠退款策略
         */
        public final static String NO_DISCOUNT_REFUND = "NO_DISCOUNT_REFUND";

        public static String getStrategy(int id) {
            switch (id) {
                case 0:
                    return NO_DISCOUNT_REFUND;
                case 1:
                    return FULL_REFUND_CUT;
                case 2:
                    return CHANGE_ORDER_REFUND_CUT;
                case 3:
                    return null;
                case 4:
                    return INTEGRAL_REFUND_CUT;
                case 5:
                    return RANDOM_CUT_REFUND;
                default:
                    return null;

            }
        }
    }
}
