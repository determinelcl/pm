package com.practice.management.bean.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class WtQueryModel {
    @NotNull(message = "用户id不能为空")
    private Long id;
    /**
     * 用户操作类型：0:admin, 1:student, 2:school, 3:enterprises
     */
    @NotNull(message = "用户类型不能为空")
    @Range(min = 0, max = 3, message = "用户类型不存在")
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
