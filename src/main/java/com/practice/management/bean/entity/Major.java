package com.practice.management.bean.entity;

import javax.validation.constraints.NotBlank;

public class Major {
    private Long id;
    @NotBlank(message = "专业所在学院不能为空")
    private String facultyName;
    @NotBlank(message = "专业名称不能为空")
    private String name;
    @NotBlank(message = "专业简介不能为空")
    private String introduce;

    private Long schoolId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
