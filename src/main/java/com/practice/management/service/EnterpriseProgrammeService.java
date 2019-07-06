package com.practice.management.service;

import com.practice.management.bean.dto.AddEpDto;
import com.practice.management.bean.dto.UpdEpDto;
import com.practice.management.bean.entity.EnterpriseProgramme;
import com.practice.management.bean.model.EpQueryModel;

import java.util.List;

public interface EnterpriseProgrammeService {
    /**
     * 根据id查询企业培训方案
     *
     * @param programmeId 企业培训方案id
     * @return 企业培训方案对象
     */
    EnterpriseProgramme findById(Long programmeId);

    /**
     * 添加企业课程
     * 角色：企业负责人
     *
     * @param dto 课程
     * @return 添加完成的课程对象
     */
    EnterpriseProgramme add(AddEpDto dto);

    /**
     * 修改企业课程
     * 角色：企业负责人
     *
     * @param dto 课程
     * @return 修改完成的课程对象
     */
    EnterpriseProgramme update(UpdEpDto dto);

    /**
     * 删除企业课程
     * 角色：企业负责人
     *
     * @param erId 企业负责人id
     * @param epId 课程id
     * @return 删除完成的课程对象
     */
    EnterpriseProgramme delete(Long erId, Long epId);

    /**
     * 查询企业课程
     * 角色：所有登录的角色
     *
     * @param queryCondition 查询条件
     * @return 查询的企业课程列表
     */
    List<EnterpriseProgramme> query(EpQueryModel queryCondition);
}
