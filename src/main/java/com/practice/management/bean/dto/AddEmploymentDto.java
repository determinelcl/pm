package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Employment;

import javax.validation.constraints.NotNull;

public class AddEmploymentDto extends Employment {

    @NotNull(message = "学生id不能为空")
    private Long stuId;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }
}
