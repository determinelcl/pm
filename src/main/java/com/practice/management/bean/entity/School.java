package com.practice.management.bean.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 学校
 * **/

public class School extends Account {
    private int id;
    private String name;
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
