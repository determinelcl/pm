package com.practice.management.bean.model;

/**
 * 企业查询条件模型
 */
public class EnpQueryModel {

    /**
     * 企业id
     */
    private Long enpId;
    /**
     * 企业老师工号：account
     */
    private String erId;
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

    public String getErId() {
        return erId;
    }

    public void setErId(String erId) {
        this.erId = erId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
