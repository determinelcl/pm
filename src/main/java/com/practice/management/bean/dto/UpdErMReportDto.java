package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdErMReportDto {
    /**
     * 企业老师ID
     */
    @NotNull(message = "企业老师id不能为空")
    private Long erId;
    /**
     * 月报id
     */
    @NotNull(message = "月报id不能为空")
    private Long monthReportId;
    @NotBlank(message = "企业意见不能为空")
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
