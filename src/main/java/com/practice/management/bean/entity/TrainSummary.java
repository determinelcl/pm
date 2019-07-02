package com.practice.management.bean.entity;

public class TrainSummary {
    private int id;
    private String trainSummary;
    private String trainReportUrl;
    private String trainDesignUrl;
    private int schoolId;
    private int studentId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
