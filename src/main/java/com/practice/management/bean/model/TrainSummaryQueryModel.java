package com.practice.management.bean.model;

public class TrainSummaryQueryModel {

    /**
     * 查询用户的id
     */
    private Long id;

    /**
     * 查询用户类型
     */
    private Integer type;

    /**
     * 学生学号
     */
    private String account;

    private String schoolName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
