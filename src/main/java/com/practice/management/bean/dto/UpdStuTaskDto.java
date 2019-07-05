package com.practice.management.bean.dto;

import org.springframework.web.multipart.MultipartFile;

public class UpdStuTaskDto {
    private Long stuId;
    private Long taskId;

    private String projectName;
    private String trainContent;
    private String projectDesignContent;
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
