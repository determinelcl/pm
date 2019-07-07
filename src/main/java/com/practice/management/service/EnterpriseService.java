package com.practice.management.service;

import com.practice.management.bean.dto.UpdEnterpriseParamDto;
import com.practice.management.bean.entity.Enterprise;
import com.practice.management.controller.EnterpriseQueryModel;

import java.util.List;

public interface EnterpriseService {

    /**
     * 添加企业信息
     *
     * @param enterprise 企业信息对象
     * @return 添加完成的企业
     */
    Enterprise add(Enterprise enterprise);

    /**
     * 根据指定的企业id查询企业
     *
     * @param enpId 企业id
     * @return 企业信息对象
     */
    Enterprise findById(Long enpId);

    /**
     * 根据企业id跟新企业信息
     *
     * @param enterprise 企业信息对象
     */
    void updateById(UpdEnterpriseParamDto enterprise);

    /**
     * 根据查询企业
     * 角色：admin
     *
     * @param queryCondition 查询条件对象
     * @return 查询的企业列表
     */
    List<Enterprise> query(EnterpriseQueryModel queryCondition);
}
