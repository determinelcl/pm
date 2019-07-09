package com.practice.management.bean.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdStuTaskDto {
    @NotNull(message = "学生id不能为空")
    private Long stuId;
    @NotNull(message = "任务书id不能为空")
    private Long taskId;

    @NotNull(message = "项目名称不能为空")
    private String projectName;
    @NotBlank(message = "任务内容不能为空")
    private String trainContent;
    @NotBlank(message = "设计内容不能为空")
    private String projectDesignContent;
    @NotBlank(message = "需求分析不能为空")
    private String designRequirement;

    private String enclosureUrl;

    // 附件
    private MultipartFile enclosureFile;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getProjectDesignContent() {
        return projectDesignContent;
    }

    public void setProjectDesignContent(String projectDesignContent) {
        this.projectDesignContent = projectDesignContent;
    }

    public String getDesignRequirement() {
        return designRequirement;
    }

    public void setDesignRequirement(String designRequirement) {
        this.designRequirement = designRequirement;
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl;
    }

    public MultipartFile getEnclosureFile() {
        return enclosureFile;
    }

    public void setEnclosureFile(MultipartFile enclosureFile) {
        this.enclosureFile = enclosureFile;
    }
}
