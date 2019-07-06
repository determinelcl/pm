package com.practice.management.bean.entity;

import java.util.Date;

/**
 * 企业
 */
public class Enterprise {
    private Long id;
    private String name;
    private String introduce;
    private Date serviceStartTime;
    private Date serviceEndTime;
    private Date addTime;
    private String remarks;
    private String responsibility_account;

    // 企业负责人id：非实体属性，用于查询
    private Long erId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Date serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Date getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Date serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getResponsibility_account() {
        return responsibility_account;
    }

    public void setResponsibility_account(String responsibility_account) {
        this.responsibility_account = responsibility_account;
    }

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
