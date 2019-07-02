package com.practice.management.bean.entity;

import java.util.Date;

/**
 * 企业
 */
public class Enterprise {
    private int id;
    private String name;
    private String introduce;
    private Date ServiceST;
    private Date ServiceET;

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
        return ServiceST;
    }

    public void setServiceST(Date serviceST) {
        ServiceST = serviceST;
    }

    public Date getServiceET() {
        return ServiceET;
    }

    public void setServiceET(Date serviceET) {
        ServiceET = serviceET;
    }
}
