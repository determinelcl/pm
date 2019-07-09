package com.practice.management.bean.dto;

import com.practice.management.bean.entity.TrainScore;

import javax.validation.constraints.NotNull;

public class AddTsDto extends TrainScore {

    /**
     * 企业负责人/老师id
     */
    @NotNull(message = "企业老师id不能为空")
    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
