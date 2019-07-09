package com.practice.management.bean.dto;

import com.practice.management.bean.entity.EnterpriseResponsibility;

import javax.validation.constraints.NotNull;

public class AddEnterpriseTeacherDto extends EnterpriseResponsibility {

    // 用于企业负责人添加企业老师
    @NotNull(message = "企业负责人id不能为空")
    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
