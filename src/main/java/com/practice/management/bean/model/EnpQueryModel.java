package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;

/**
 * 企业查询条件模型
 */
public class EnpQueryModel {

    /**
     * 企业id
     */
    private Long enpId;
    /**
     * 企业负责人id
     */
    @NotNull(message = "企业负责人id不能为空")
    private Long erId;
    /**
     * 企业老师工号：account
     */
    private String account;
    /**
     * 企业老师姓名：name
     */
    private String name;

    public Long getEnpId() {
        return enpId;
    }

    public void setEnpId(Long enpId) {
        this.enpId = enpId;
    }

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
