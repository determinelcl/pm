package com.practice.management.bean.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class WeekTrain {
    private Long id;
    @NotNull(message = "实训周次不能为空")
    private Integer trainTimes;
    @NotNull(message = "实训人数不能为空")
    private Integer trainNumber;
    @NotNull(message = "实训开始时间不能为空")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @NotNull(message = "实训结束名称时间不能为空")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @NotBlank(message = "实训基地不能为空")
    private String baseName;
    @NotBlank(message = "教学情况不能为空")
    private String weekTeach;
    @NotBlank(message = "学生每周学习情况不能为空")
    private String weekStudentLearn;
    @NotBlank(message = "反馈重点不能为空")
    private String feedbackFocus;
    @NotBlank(message = "实训考核情况")
    private String trainAssessmentSituation;
    @NotNull(message = "专业id不能为空")
    private Long majorId;
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrainTimes() {
        return trainTimes;
    }

    public void setTrainTimes(Integer trainTimes) {
        this.trainTimes = trainTimes;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
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

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getWeekTeach() {
        return weekTeach;
    }

    public void setWeekTeach(String weekTeach) {
        this.weekTeach = weekTeach;
    }

    public String getWeekStudentLearn() {
        return weekStudentLearn;
    }

    public void setWeekStudentLearn(String weekStudentLearn) {
        this.weekStudentLearn = weekStudentLearn;
    }

    public String getFeedbackFocus() {
        return feedbackFocus;
    }

    public void setFeedbackFocus(String feedbackFocus) {
        this.feedbackFocus = feedbackFocus;
    }

    public String getTrainAssessmentSituation() {
        return trainAssessmentSituation;
    }

    public void setTrainAssessmentSituation(String trainAssessmentSituation) {
        this.trainAssessmentSituation = trainAssessmentSituation;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
