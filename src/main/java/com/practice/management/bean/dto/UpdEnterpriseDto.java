package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Enterprise;

public class UpdEnterpriseDto {
    /**
     * 企业负责人id
     */
    private Long erId;

    /**
     * 企业对象
     */
    private Enterprise enterprise;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
