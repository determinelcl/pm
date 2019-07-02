package com.practice.management.bean.entity;


/*
 * 企业责任人
 * */

public class EnterpriseResponsilbility extends Account {
    private String rank;

    private int enterpriseId;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
