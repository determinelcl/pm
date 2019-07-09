package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Student;

import javax.validation.constraints.NotNull;

public class AddStudentDto extends Student {

    /**
     * 学校负责人id
     */
    @NotNull(message = "学校老师id不能为空")
    private Long srId;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }
}
