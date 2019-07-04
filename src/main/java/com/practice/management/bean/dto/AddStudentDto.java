package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Student;

public class AddStudentDto extends Student {

    /**
     * 学校负责人id
     */
    private Long srId;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }
}
