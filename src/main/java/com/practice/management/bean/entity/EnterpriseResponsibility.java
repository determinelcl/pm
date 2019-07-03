package com.practice.management.bean.entity;


/**
 * 企业责任人
 */
public class EnterpriseResponsibility extends Account {
    private String rank;

    private Long enterpriseId;

    // 用于注册用户时同时添加企业，非实体属性
    private Enterprise enterprise;
    // 用于企业负责人修改企业老师，非实体属性
    private Long erId;

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

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
