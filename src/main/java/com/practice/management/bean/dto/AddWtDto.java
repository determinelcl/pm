package com.practice.management.bean.dto;

import com.practice.management.bean.entity.WeekTrain;

public class AddWtDto extends WeekTrain {

    private Long erId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }
}
