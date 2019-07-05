package com.practice.management.bean.dto;

import com.practice.management.bean.entity.TrainScore;

public class AddTsDto extends TrainScore {

    /**
     * 企业负责人/老师id
     */
    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
