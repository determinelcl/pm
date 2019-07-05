package com.practice.management.bean.dto;

import org.springframework.web.multipart.MultipartFile;

public class UpdStuTrainSummaryDto {

    private Long stuId;
    private Long tsId;
    private String trainSummary;
    private String trainReportUrl;
    private String trainDesignUrl;

    private MultipartFile trainReport;
    private MultipartFile trainDesign;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getTsId() {
        return tsId;
    }

    public void setTsId(Long tsId) {
        this.tsId = tsId;
    }

    public String getTrainSummary() {
        return trainSummary;
    }

    public void setTrainSummary(String trainSummary) {
        this.trainSummary = trainSummary;
    }

    public String getTrainReportUrl() {
        return trainReportUrl;
    }

    public void setTrainReportUrl(String trainReportUrl) {
        this.trainReportUrl = trainReportUrl;
    }

    public String getTrainDesignUrl() {
        return trainDesignUrl;
    }

    public void setTrainDesignUrl(String trainDesignUrl) {
        this.trainDesignUrl = trainDesignUrl;
    }

    public MultipartFile getTrainReport() {
        return trainReport;
    }

    public void setTrainReport(MultipartFile trainReport) {
        this.trainReport = trainReport;
    }

    public MultipartFile getTrainDesign() {
        return trainDesign;
    }

    public void setTrainDesign(MultipartFile trainDesign) {
        this.trainDesign = trainDesign;
    }
}
