package com.practice.management.bean.entity;

public class Student extends Account {

    private String classes;

    private Long enterpriseId;

    private Long enterpriseProgrammeId;

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
