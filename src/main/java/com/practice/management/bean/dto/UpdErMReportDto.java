package com.practice.management.bean.dto;

public class UpdErMReportDto {
    /**
     * 企业老师ID
     */
    private Long erId;
    /**
     * 月报id
     */
    private Long monthReportId;

    private String enterpriseOpinion;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Long getMonthReportId() {
        return monthReportId;
    }

    public void setMonthReportId(Long monthReportId) {
        this.monthReportId = monthReportId;
    }

    public String getEnterpriseOpinion() {
        return enterpriseOpinion;
    }

    public void setEnterpriseOpinion(String enterpriseOpinion) {
        this.enterpriseOpinion = enterpriseOpinion;
    }
}
