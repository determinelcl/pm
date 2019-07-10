package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;

public class MajorQueryModel {
    @NotNull(message = "学校id不能为空")
    private Long schoolId;
    private String name;
    private String facultyName;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
