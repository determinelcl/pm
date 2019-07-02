package com.practice.management.bean.entity;

public class Student extends Account {

    private String classes;

    private int enterpriseId;

    private int enterpriseProgrammeId;

    private int majorId;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getEnterpriseProgrammeId() {
        return enterpriseProgrammeId;
    }

    public void setEnterpriseProgrammeId(int enterpriseProgrammeId) {
        this.enterpriseProgrammeId = enterpriseProgrammeId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
}
