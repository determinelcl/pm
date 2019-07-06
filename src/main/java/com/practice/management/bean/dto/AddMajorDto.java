package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Major;

public class AddMajorDto extends Major {
    private Long srId;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }
}
