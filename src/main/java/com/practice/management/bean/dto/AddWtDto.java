package com.practice.management.bean.dto;

import com.practice.management.bean.entity.WeekTrain;

import javax.validation.constraints.NotNull;

public class AddWtDto extends WeekTrain {

    @NotNull(message = "企业负责人不能为空")
    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
