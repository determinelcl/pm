package com.practice.management.bean.dto;

import com.practice.management.bean.entity.SchoolResponsibility;

public class AddSchoolTeacherDto extends SchoolResponsibility {

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
