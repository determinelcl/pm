package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;

public class EpQueryModel {
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    /**
     * 企业课程名称
     */
    private String epName;
    /**
     * 企业名称
     */
    private String enterpriseName;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
