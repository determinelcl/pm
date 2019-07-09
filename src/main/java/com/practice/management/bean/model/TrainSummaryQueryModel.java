package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;

public class TrainSummaryQueryModel {

    /**
     * 查询用户的id
     */
    @NotNull(message = "用户id不能为空")
    private Long id;

    /**
     * 查询用户类型
     */
    @NotNull(message = "用户类型不能为空")
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
