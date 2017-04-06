package com.saras.template.core.strategy.demo.base;

import com.saras.template.utils.ToString;

/**
 * description:
 * saras_xu@163.com 2017-04-06 13:43 创建
 */
public class TestBiz {
    private String type;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
