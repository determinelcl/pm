package com.practice.management.service;

import com.practice.management.bean.entity.School;

public interface SchoolService {

    /**
     * 添加学校对象
     * @param school 学校对象
     */
    School add(School school);

    School findById(Long schoolId);
}
