package com.practice.management.bean.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student extends Account {

    @NotBlank(message = "学生班级不能为空")
    private String classes;

    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    @NotNull(message = "企业课程id不能为空")
    private Long enterpriseProgrammeId;

    @NotNull(message = "专业id不能为空")
    private Long majorId;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseProgrammeId() {
        return enterpriseProgrammeId;
    }

    public void setEnterpriseProgrammeId(Long enterpriseProgrammeId) {
        this.enterpriseProgrammeId = enterpriseProgrammeId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }
}
