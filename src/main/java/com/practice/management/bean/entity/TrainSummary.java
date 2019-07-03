package com.practice.management.bean.entity;

public class TrainSummary {
    private Long id;
    private String trainSummary;
    private String trainReportUrl;
    private String trainDesignUrl;
    private Long schoolId;
    private Long studentId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainSummary() {
        return trainSummary;
    }

    public void setTrainSummary(String trainSummary) {
        this.trainSummary = trainSummary;
    }

    public String getTrainReportUrl() {
        return trainReportUrl;
    }

    public void setTrainReportUrl(String trainReportUrl) {
        this.trainReportUrl = trainReportUrl;
    }

    public String getTrainDesignUrl() {
        return trainDesignUrl;
    }

    public void setTrainDesignUrl(String trainDesignUrl) {
        this.trainDesignUrl = trainDesignUrl;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
