package com.practice.management.bean.dto;

import com.practice.management.bean.entity.EnterpriseResponsibility;

public class AddEnterpriseTeacherDto extends EnterpriseResponsibility {

    // 用于企业负责人添加企业老师
    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
