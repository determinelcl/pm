package com.practice.management.service;

import com.practice.management.bean.dto.AddEmploymentDto;
import com.practice.management.bean.dto.UpdEmploymentDto;
import com.practice.management.bean.entity.Employment;
import com.practice.management.bean.model.EmploymentQueryModel;

import java.util.List;

public interface EmploymentStatisticService {
    /**
     * 添加就业统计
     * 角色：学生
     *
     * @param dto 就业统计dto
     * @return 添加成功的就业统计
     */
    Employment add(AddEmploymentDto dto);

    /**
     * 根据id查询就业统计记录
     *
     * @param eId 就业统计记录id
     * @return 就业统计记录
     */
    Employment findById(Long eId);

    /**
     * 更新就业统计
     * 角色：学生
     *
     * @param dto 就业统计dto
     * @return 更新成功的就业统计
     */
    Employment update(UpdEmploymentDto dto);

    /**
     * 查询就业统计
     * 角色：学校/企业/学生
     *
     * @param queryCondition 查询条件
     * @return 查询的就业统计的结果列表
     */
    List<Employment> query(EmploymentQueryModel queryCondition);
}
