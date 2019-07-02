package com.practice.management.bean.entity;

public class TrainScore {
    private int id;
    private String lessonName;
    private double stageOne;
    private double stageTwo;
    private double stageThree;
    private double stageFour;
    private double stageFire;
    private int coefficientId;
    private int majorId;
    private int schoolId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public double getStageOne() {
        return stageOne;
    }

    public void setStageOne(double stageOne) {
        this.stageOne = stageOne;
    }

    public double getStageTwo() {
        return stageTwo;
    }

    public void setStageTwo(double stageTwo) {
        this.stageTwo = stageTwo;
    }

    public double getStageThree() {
        return stageThree;
    }

    public void setStageThree(double stageThree) {
        this.stageThree = stageThree;
    }

    public double getStageFour() {
        return stageFour;
    }

    public void setStageFour(double stageFour) {
        this.stageFour = stageFour;
    }

    public double getStageFire() {
        return stageFire;
    }

    public void setStageFire(double stageFire) {
        this.stageFire = stageFire;
    }

    public int getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(int coefficientId) {
        this.coefficientId = coefficientId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
}
