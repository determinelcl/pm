package com.practice.management.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class Task {
    private Long id;
    @NotNull(message = "项目名称不能为空")
    private String projectName;
    private String year;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;
    @NotBlank(message = "企业老师姓名不能为空")
    private String enterpriseTeacherName;
    @NotBlank(message = "学校老师姓名不能为空")
    private String schoolTeacherName;
    @NotBlank(message = "任务内容不能为空")
    private String trainContent;
    @NotBlank(message = "设计内容不能为空")
    private String projectDesignContent;
    @NotBlank(message = "需求分析不能为空")
    private String designRequirement;
    private String enclosureUrl;
    @Null(message = "学生不能自己填写企业意见")
    private String enterpriseOpinion;
    @Null(message = "学生不可以自己进行审核")
    private String schoolExamine;
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    private Long schoolId;
    @NotNull(message = "学生id不能为空")
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEnterpriseTeacherName() {
        return enterpriseTeacherName;
    }

    public void setEnterpriseTeacherName(String enterpriseTeacherName) {
        this.enterpriseTeacherName = enterpriseTeacherName;
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

    public String getDesignRequirement() {
        return designRequirement;
    }

    public void setDesignRequirement(String designRequirement) {
        this.designRequirement = designRequirement;
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

    public String getSchoolExamine() {
        return schoolExamine;
    }

    public void setSchoolExamine(String schoolExamine) {
        this.schoolExamine = schoolExamine;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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
