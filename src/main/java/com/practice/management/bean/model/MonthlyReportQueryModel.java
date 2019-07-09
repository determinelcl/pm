package com.practice.management.bean.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 学生学号、提交时间、学校名称、企业name
 */
public class MonthlyReportQueryModel {
    /**
     * 查询用户的id
     */
    @NotNull(message = "查询月报的用户id不能为空")
    private Long id;

    /**
     * 查询用户类型
     */
    @NotNull(message = "查询月报的用户的类型不能为空")
    private Integer type;

    /**
     * 学生学号
     */
    private String account;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;

    private String schoolName;

    private String enpName;

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
