package com.practice.management.bean.entity;

public class SchoolResponsibility extends Account {
    private String rank;

    private Long majorId;

    private Long schoolId;

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
}

