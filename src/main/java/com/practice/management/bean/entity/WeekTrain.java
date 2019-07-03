package com.practice.management.bean.entity;


import java.util.Date;

public class WeekTrain {
    private Long id;
    private int trainTimes;
    private Date startTime;
    private Date EndTime;
    private String baseName;
    private String weekTeach;
    private String weekStuLearn;
    private String feedbackFocus;
    private String trainSituation;
    private Long majorId;
    private Long schoolId;
    private Long enterpriseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTrainTimes() {
        return trainTimes;
    }

    public void setTrainTimes(int trainTimes) {
        this.trainTimes = trainTimes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
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

    public String getWeekStuLearn() {
        return weekStuLearn;
    }

    public void setWeekStuLearn(String weekStuLearn) {
        this.weekStuLearn = weekStuLearn;
    }

    public String getFeedbackFocus() {
        return feedbackFocus;
    }

    public void setFeedbackFocus(String feedbackFocus) {
        this.feedbackFocus = feedbackFocus;
    }

    public String getTrainSituation() {
        return trainSituation;
    }

    public void setTrainSituation(String trainSituation) {
        this.trainSituation = trainSituation;
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

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
