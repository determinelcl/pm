package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;

public class TsQueryModel {
    /**
     * 企业负责人/老师、学校负责人/老师、学生
     */
    @NotNull(message = "用户id不能为空")
    private Long id;
    /**
     * 1：学生，2：老师，3：企业
     */
    @NotNull(message = "用户类型不能为空")
    private Integer type;

    private String majorName;

    private String lessonName;

    private String schoolName;

    private Long coefficientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Long getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(Long coefficientId) {
        this.coefficientId = coefficientId;
    }
}
