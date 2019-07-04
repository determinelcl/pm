package com.practice.management.service;

import com.practice.management.bean.dto.*;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.SchoolQueryModel;

import java.util.List;

public interface SchoolResponsibilityService {
    /**
     * 学校负责人修改学校信息
     *
     * @param dto 学校信息dto
     * @return 修改后的学校信息
     */
    School updSchool(UpdSchoolDto dto);

    /**
     * 学校负责人添加学生信息
     *
     * @param dto 学生信息对象
     */
    void addStudent(AddStudentDto dto);

    /**
     * 添加学校老师信息
     *
     * @param dto 学校老师信息dto
     */
    void addSchoolTeacher(AddSchoolTeacherDto dto);

    /**
     * 学校负责人和老师更新个人信息
     *
     * @param dto 学校负责人和老师dto
     * @return 更新之后的学校负责人和老师信息
     */
    SchoolResponsibility updateSr(UpdSrDto dto);

    /**
     * 学校负责人更新老师更新信息
     *
     * @param dto 学校老师信息dto
     * @return 更新之后学校老师的信息
     */
    SchoolResponsibility updSrTeacher(UpdSchoolTeacherDto dto);

    /**
     * 学校老师根据指定的学校老师id删除学校老师
     * 角色：学校负责人
     *
     * @param srId 学校负责人id
     * @param stId 学校老师id
     * @return 删除的学校老师信息
     */
    SchoolResponsibility deleteById(Long srId, Long stId);

    /**
     * 根据给定的条件查询学校老师
     * 角   色：学校负责人
     * 查询条件：专业name、老师id/name
     *
     * @param queryCondition 学校负责人实体的所有字段都可以作为查询条件
     * @return 查询到的学校负责人信息
     */
    List<SchoolResponsibility> queryByCondition(SchoolQueryModel queryCondition);
}
