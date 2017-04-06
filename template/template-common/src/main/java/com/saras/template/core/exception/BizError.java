package com.saras.template.core.exception;

/**
 * description:
 * saras_xu@163.com 2017-03-01 11:19 创建
 */
public class BizError extends RuntimeException {

    private static final long serialVersionUID = 2492449662231853945L;

    private String code;

    public BizError() {
        super();
    }

    /**
     * 构建一个<code>BizError.java</code>
     * msg为自定义信息
     * 此方法适用于 直接抛出自己定义的信息
     *
     * @param msg
     */
    public BizError(String msg) {
        super(msg);
    }

    public BizError(String message, String code) {
        super(code);
        this.code = code;
    }

    public BizError(String message, Throwable cause) {
        super(message, cause);
    }

    public BizError(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
