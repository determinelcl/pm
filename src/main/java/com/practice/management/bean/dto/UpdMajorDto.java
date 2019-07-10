package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdMajorDto {
    @NotNull(message = "学校负责人id不能为空")
    private Long srId;
    @NotNull(message = "专业id不能为空")
    private Long majorId;
    @NotBlank(message = "专业所在学院不能为空")
    private String facultyName;
    @NotBlank(message = "专业名称不能为空")
    private String name;
    @NotBlank(message = "专业简介不能为空")
    private String introduce;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
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
}
