package com.practice.management.bean.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TrainScore {
    private Long id;

    @NotBlank(message = "课程名不能为空")
    private String lessonName;
    @DecimalMax(value = "100", message = "成绩最大不能超过100")
    @DecimalMin(value = "0", message = "成绩最小不能小于0")
    @NotNull(message = "成绩不能为空")
    private double stageOne;
    @DecimalMax(value = "100", message = "成绩最大不能超过100")
    @DecimalMin(value = "0", message = "成绩最小不能小于0")
    @NotNull(message = "成绩不能为空")
    private double stageTwo;
    @DecimalMax(value = "100", message = "成绩最大不能超过100")
    @DecimalMin(value = "0", message = "成绩最小不能小于0")
    @NotNull(message = "成绩不能为空")
    private double stageThree;
    @DecimalMax(value = "100", message = "成绩最大不能超过100")
    @DecimalMin(value = "0", message = "成绩最小不能小于0")
    @NotNull(message = "成绩不能为空")
    private double stageFour;
    @DecimalMax(value = "100", message = "成绩最大不能超过100")
    @DecimalMin(value = "0", message = "成绩最小不能小于0")
    @NotNull(message = "成绩不能为空")
    private double stageFive;
    @NotNull(message = "阶段系数id不能为空")
    private Long coefficientId;
    @NotNull(message = "学校id不能为空")
    private Long studentId;
    @NotNull(message = "企业课程id不能为空")
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

    public double getStageFive() {
        return stageFive;
    }

    public void setStageFive(double stageFive) {
        this.stageFive = stageFive;
    }

    public Long getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(Long coefficientId) {
        this.coefficientId = coefficientId;
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

    public Long getEnterpriseProgrammeId() {
        return enterpriseProgrammeId;
    }

    public void setEnterpriseProgrammeId(Long enterpriseProgrammeId) {
        this.enterpriseProgrammeId = enterpriseProgrammeId;
    }
}
