package com.practice.management.bean.dto;

public class UpdWtDto {
    private Long erId;
    private Long wtId;

    private Integer trainTimes;
    private Integer trainNumber;
    private String baseName;
    private String weekTeach;
    private String weekStudentLearn;
    private String feedbackFocus;
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
