package com.practice.management.bean.model;

import java.util.Date;

public class WtQueryModel {
    private Long id;
    /**
     * 用户操作类型：0:admin, 1:student, 2:school, 3:enterprises
     */
    private Integer type;

    private String majorName;
    private String enpName;
    private Date time;

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

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getEnpName() {
        return enpName;
    }

    public void setEnpName(String enpName) {
        this.enpName = enpName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
