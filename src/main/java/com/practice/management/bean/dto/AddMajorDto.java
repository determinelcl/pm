package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Major;

import javax.validation.constraints.NotNull;

public class AddMajorDto extends Major {
    @NotNull(message = "学校负责人id不能为空")
    private Long srId;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }
}
