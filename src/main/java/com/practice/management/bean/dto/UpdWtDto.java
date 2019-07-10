package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdWtDto {
    @NotNull(message = "企业负责人不能为空")
    private Long erId;
    @NotNull(message = "每周实训情况id不能为空")
    private Long wtId;

    @NotNull(message = "实训周次不能为空")
    private Integer trainTimes;
    @NotNull(message = "实训人数不能为空")
    private Integer trainNumber;
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

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Long getWtId() {
        return wtId;
    }

    public void setWtId(Long wtId) {
        this.wtId = wtId;
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
}
