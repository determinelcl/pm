package com.practice.management.bean.entity;


/*
 * 企业责任人
 * */

public class EnterpriseResponsibility extends Account {
    private String rank;

    private Long enterpriseId;

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
}
