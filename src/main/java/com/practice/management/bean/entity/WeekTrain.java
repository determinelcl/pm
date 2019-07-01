package com.practice.management.bean.entity;


import java.util.Date;

public class WeekTrain {
    private int id;
    private int trainTimes;
    private Date startTime;
    private Date EndTime;
    private String baseName;
    private String weekTeach;
    private String weekStuLearn;
    private String feedbackFocus;
    private String trainSituation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
