package com.practice.management.bean.dto;

public class UpdSchoolDto {

    /**
     * 学校负责人id
     */
    private Long srId;

    /**
     * 学校信息
     */
    private UpdSchoolParamDto school;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public UpdSchoolParamDto getSchool() {
        return school;
    }

    public void setSchool(UpdSchoolParamDto school) {
        this.school = school;
    }
}
