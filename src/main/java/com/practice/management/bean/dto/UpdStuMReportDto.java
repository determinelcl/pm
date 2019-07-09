package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdStuMReportDto {
    /**
     * 学生ID
     */
    @NotNull(message = "学生id不能为空")
    private Long stuId;
    /**
     * 月报id
     */
    @NotNull(message = "月报id不能为空")
    private Long monthReportId;
    @NotBlank(message = "实训内容不能为空")
    private String trainContent;
    @NotBlank(message = "实训总结不能为空")
    private String trainHarvest;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getMonthReportId() {
        return monthReportId;
    }

    public void setMonthReportId(Long monthReportId) {
        this.monthReportId = monthReportId;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getTrainHarvest() {
        return trainHarvest;
    }

    public void setTrainHarvest(String trainHarvest) {
        this.trainHarvest = trainHarvest;
    }
}
