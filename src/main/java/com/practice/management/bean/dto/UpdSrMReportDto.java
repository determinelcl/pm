package com.practice.management.bean.dto;

public class UpdSrMReportDto {

    /**
     * 学校老师ID
     */
    private Long srId;
    /**
     * 月报id
     */
    private Long monthReportId;

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
