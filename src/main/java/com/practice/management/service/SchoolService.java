package com.practice.management.service;

import com.practice.management.bean.dto.UpdSchoolParamDto;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.model.SchoolQueryModel;

import java.util.List;

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

    /**
     * 根据查询学校
     * 角色：admin
     *
     * @param queryCondition 查询条件对象
     * @return 查询的学校列表
     */
    List<School> query(SchoolQueryModel queryCondition);
}
