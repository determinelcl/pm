package com.practice.management.bean.dto;

public class UpdTsDto {
    /**
     * 企业负责人/老师id
     */
    private Long erId;
    /**
     * 实训成绩id
     */
    private Long tsId;
    private String lessonName;
    private double stageOne;
    private double stageTwo;
    private double stageThree;
    private double stageFour;
    private double stageFire;
    private Long coefficientId;
    private Long enterpriseProgrammeId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Long getTsId() {
        return tsId;
    }

    public void setTsId(Long tsId) {
        this.tsId = tsId;
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

    public Long getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(Long coefficientId) {
        this.coefficientId = coefficientId;
    }

    public Long getEnterpriseProgrammeId() {
        return enterpriseProgrammeId;
    }

    public void setEnterpriseProgrammeId(Long enterpriseProgrammeId) {
        this.enterpriseProgrammeId = enterpriseProgrammeId;
    }
}
