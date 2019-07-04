package com.practice.management.service;

import com.practice.management.bean.dto.UpdSchoolParamDto;
import com.practice.management.bean.entity.School;

public interface SchoolService {

    /**
     * 添加学校对象
     * @param school 学校对象
     */
    School add(School school);

    /**
     * 根据学校id查询学校
     *
     * @param schoolId 学校id
     * @return 学校信息对象
     */
    School findById(Long schoolId);

    /**
     * 根据学校id跟新学校信息
     *
     * @param school 学校
     * @return 更新的学校信息
     */
    School updateById(UpdSchoolParamDto school);
}
