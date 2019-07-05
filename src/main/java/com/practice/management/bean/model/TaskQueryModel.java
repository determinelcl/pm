package com.practice.management.bean.model;

import java.util.Date;

public class TaskQueryModel {

    /**
     * 查询用户的id
     */
    private Long id;

    /**
     * 查询用户类型
     */
    private String type;

    /**
     * 学生学号
     */
    private String account;

    private String projectName;

    private Date submitTime;

    private String schoolName;

    private String enpName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getEnpName() {
        return enpName;
    }

    public void setEnpName(String enpName) {
        this.enpName = enpName;
    }
}
