package com.practice.management.bean.entity;

import java.util.Date;

/**
 * 学校
 */
public class School {
    private int id;
    private String name;
    private String introduce;
    private Date serviceST;
    private Date serviceET;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getServiceST() {
        return serviceST;
    }

    public void setServiceST(Date serviceST) {
        this.serviceST = serviceST;
    }

    public Date getServiceET() {
        return serviceET;
    }

    public void setServiceET(Date serviceET) {
        this.serviceET = serviceET;
    }
}
