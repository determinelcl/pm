package com.practice.management.bean.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class QueryEnpFileUploadModel {

    /**
     * 企业负责人/老师
     */
    @NotNull(message = "企业负责人id不能为空")
    private Long erId;

    private Date submitTime;
    private String fileType;
    private String schoolName;
    private Long enterpriseId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
