package com.practice.management.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * 月报
 */
public class MonthReport {
    private Long id;

    @NotNull(message = "开始时间不能为空")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @NotNull(message = "结束时间不能为空")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @NotBlank(message = "训练内容不能为空")
    private String trainContent;
    @NotBlank(message = "训练总结不能为空")
    private String trainHarvest;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date submitTime;
    private String year;
    @Null(message = "学生不能自己填写企业意见")
    private String enterpriseOpinion;
    @Null(message = "学生不可以自己进行审核")
    private String schoolExamine;
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;
    @NotNull(message = "学校id不能为空")
    private Long schoolId;
    @NotNull(message = "学生id不能为空")
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getTrainHarvest() {
        return trainHarvest;
    }

    public void setTrainHarvest(String trainHarvest) {
        this.trainHarvest = trainHarvest;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
