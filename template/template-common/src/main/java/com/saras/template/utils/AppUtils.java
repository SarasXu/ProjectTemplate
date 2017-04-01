package com.saras.template.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.Map;

/**
 * description:
 * saras_xu@163.com 2017-03-07 08:54 创建
 */
public class AppUtils {


    /**
     * 生成20订单编号
     *
     * @return
     */
    public static String newNo() {
        return DateUtils.allDate(new Date()) + RandomStringUtils.randomNumeric(3);
    }

    /**
     * 是否包含特殊字符(姓名除下划线、数字、字母以及·以外的所有字符) 包含：true 不包含：false
     * 支持英文名、中文名、少数名族特殊字符效验
     *
     * @param str
     * @return
     */
    public static boolean hasSpecSymbol(String str) {
        return !isBlank(str) && !str.matches("^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$");
    }

    /**
     * 是否全为数字 是：true 不是：false
     *
     * @param str
     * @return
     */
    public static boolean isAllNumber(String str) {
        return !isBlank(str) && str.matches("^\\d+$");
    }

    /**
     * 是否为手机
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        return !isBlank(str) && str.matches("^(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[57])[0-9]{8}$");
    }

    /**
     * 检查字符串是否是邮件地址
     *
     * @param address
     * @return
     */
    public static boolean isEmail(String address) {
        return !isBlank(address) && address.matches("^\\s*?(.+)@(.+?)\\s*$");
    }

    /**
     * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * <p/>
     * <p>
     * <pre>
     * AppUtils.isBlank(null)      = true
     * AppUtils.isBlank("")        = true
     * AppUtils.isBlank(" ")       = true
     * AppUtils.isBlank("yyy")     = false
     * AppUtils.isBlank("  yyy  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符串是否不是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * <p/>
     * <p>
     * <pre>
     * AppUtils.isNotBlank(null)      = false
     * AppUtils.isNotBlank("")        = false
     * AppUtils.isNotBlank(" ")       = false
     * AppUtils.isNotBlank("yyy")     = true
     * AppUtils.isNotBlank("  yyy  ") = true
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }


    public static boolean hasBlank(String... str) {
        if (str == null) {
            return true;
        }
        for (String aStr : str) {
            if (isBlank(aStr)) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject mapToJson(Map<?, ?> map) {
        return JSONObject.parseObject(JSON.toJSONString(map));
    }

}
