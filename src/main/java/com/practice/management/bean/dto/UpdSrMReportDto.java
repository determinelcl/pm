package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdSrMReportDto {

    /**
     * 学校老师ID
     */
    @NotNull(message = "学校老师id不能为空")
    private Long srId;
    /**
     * 月报id
     */
    @NotNull(message = "月报id不能为空")
    private Long monthReportId;

    @NotBlank(message = "学校审核意见不能为空")
    private String schoolExamine;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getMonthReportId() {
        return monthReportId;
    }

    public void setMonthReportId(Long monthReportId) {
        this.monthReportId = monthReportId;
    }

    public String getSchoolExamine() {
        return schoolExamine;
    }

    public void setSchoolExamine(String schoolExamine) {
        this.schoolExamine = schoolExamine;
    }
}
