package com.practice.management.bean.entity;


/*
 * 企业责任人
 * */

public class EnterpriseResponsibility extends Account {
    private String rank;

    private Long enterpriseId;

    // 用于注册用户时同时添加企业，非实体属性
    private Enterprise enterprise;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
