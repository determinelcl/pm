package com.practice.management.bean.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SchoolResponsibility extends Account {
    @NotBlank(message = "学校老师职称不能为空")
    private String rank;
    @NotNull(message = "专业id不能为空")
    private Long majorId;
    private Long schoolId;

    // 用于注册用户时同时添加学校，非实体属性
    private School school;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

