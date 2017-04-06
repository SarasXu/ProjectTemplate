package com.saras.template.core.template.base;


import com.saras.template.utils.ToString;

import java.io.Serializable;

/**
 * description:
 * saras_xu@163.com 2017-03-01 14:45 创建
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 7964440651025911165L;
    /**
     * 结果状态
     */
    protected Status status;
    /**
     * 描述
     */
    protected String description;

    /**
     * 错误码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
        return this.status == Status.SUCCESS;
    }

    public boolean isFail() {
        return this.status == Status.FAIL;
    }

    public boolean isProcessing() {
        return this.status == Status.PROCESSING;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
