package com.saras.template.core.template.base;


import com.saras.template.core.exception.BizError;
import com.saras.template.utils.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.Set;

/**
 * description:建议作为所有订单和表单的基类
 * saras_xu@163.com 2017-03-01 14:45 创建
 */
public class BaseOrder implements Serializable {
    private static final long serialVersionUID = -2427019332806095916L;
    /**
     * 此流水号没有任何业务规则，只是为了跟踪业务形态设置
     */
    @NotBlank(message = "业务请求流水号不能为空")
    private String serialNo;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public void check() {
        checkWithGroup();
    }

    /**
     * 通过jsr303规范的注解来校验参数
     *
     * @param groups 校验groups
     */
    public void checkWithGroup(Class<?>... groups) {
        Set<ConstraintViolation<BaseOrder>> constraintViolations = AppValidatorFactory.INSTANCE.getValidator()
                .validate(this, groups);
        validate(constraintViolations);
    }

    private <T> void validate(Set<ConstraintViolation<T>> constraintViolations) {
        StringBuffer buffer = null;
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            buffer = new StringBuffer();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                buffer.append(constraintViolation.getMessage()).append(";");
            }
            buffer.delete(buffer.length() - 1, buffer.length());
        }
        if (null != buffer) {
            throw new BizError(buffer.toString());
        }
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
