package com.practice.management.bean.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdTsDto {
    /**
     * 企业负责人/老师id
     */
    @NotNull(message = "企业老师id不能为空")
    private Long erId;
    /**
     * 实训成绩id
     */
    @NotNull(message = "实习成绩id不能为空")
    private Long tsId;
    @NotBlank(message = "实习成绩的课程名称不能为空")
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
}
