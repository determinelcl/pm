package com.practice.management.bean.entity;

public class TrainScore {
    private Long id;
    private String lessonName;
    private double stageOne;
    private double stageTwo;
    private double stageThree;
    private double stageFour;
    private double stageFire;
    private Long coefficientId;
    private Long majorId;
    private Long schoolId;
    private Long studentId;
    private Long enterpriseId;
    private Long enterpriseProgrammeId;

    /**
     * 阶段系数：非成绩表中的属性
     */
    private Coefficient coefficient;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(Long coefficientId) {
        this.coefficientId = coefficientId;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Coefficient getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Coefficient coefficient) {
        this.coefficient = coefficient;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseProgrammeId() {
        return enterpriseProgrammeId;
    }

    public void setEnterpriseProgrammeId(Long enterpriseProgrammeId) {
        this.enterpriseProgrammeId = enterpriseProgrammeId;
    }
}
