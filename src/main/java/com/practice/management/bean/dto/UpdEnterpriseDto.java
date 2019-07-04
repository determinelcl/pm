package com.practice.management.bean.dto;

public class UpdEnterpriseDto {
    /**
     * 企业负责人id
     */
    private Long erId;

    /**
     * 企业对象
     */
    private UpdEnterpriseParamDto enterprise;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public UpdEnterpriseParamDto getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(UpdEnterpriseParamDto enterprise) {
        this.enterprise = enterprise;
    }
}
