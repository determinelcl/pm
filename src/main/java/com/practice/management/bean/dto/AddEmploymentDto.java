package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Employment;

public class AddEmploymentDto extends Employment {

    private Long stuId;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }
}
