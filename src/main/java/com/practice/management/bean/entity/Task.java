package com.practice.management.bean.entity;

import java.util.Date;

public class Task {
    private int id;
    private String projectName;
    private String year;
    private Date submitTime;
    private String enterpiseTeracherName;
    private String schoolTeacherName;
    private String trainContent;
    private String projectDesignContent;
    private String designRequirment;
    private String enclosureUrl;
    private String enterpriseOpinion;
    private String schoolEamine;
    private int enterpriseId;
    private int schoolId;
    private int studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getEnterpiseTeracherName() {
        return enterpiseTeracherName;
    }

    public void setEnterpiseTeracherName(String enterpiseTeracherName) {
        this.enterpiseTeracherName = enterpiseTeracherName;
    }

    public String getSchoolTeacherName() {
        return schoolTeacherName;
    }

    public void setSchoolTeacherName(String schoolTeacherName) {
        this.schoolTeacherName = schoolTeacherName;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getProjectDesignContent() {
        return projectDesignContent;
    }

    public void setProjectDesignContent(String projectDesignContent) {
        this.projectDesignContent = projectDesignContent;
    }

    public String getDesignRequirment() {
        return designRequirment;
    }

    public void setDesignRequirment(String designRequirment) {
        this.designRequirment = designRequirment;
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl;
    }

    public String getEnterpriseOpinion() {
        return enterpriseOpinion;
    }

    public void setEnterpriseOpinion(String enterpriseOpinion) {
        this.enterpriseOpinion = enterpriseOpinion;
    }

    public String getSchoolEamine() {
        return schoolEamine;
    }

    public void setSchoolEamine(String schoolEamine) {
        this.schoolEamine = schoolEamine;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
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
