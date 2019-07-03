package com.practice.management.service;

import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;

import java.util.List;

public interface EnterpriseResponsibilityService {
    /**
     * 企业负责人修改企业信息
     *
     * @param er 企业负责人
     */
    void updEnterprise(EnterpriseResponsibility er);

    /**
     * 根据企业负责人id查询企业负责人
     *
     * @param erId 企业id
     * @return 企业负责人信息对象
     */
    EnterpriseResponsibility findById(Long erId);

    /**
     * 根据企业负责人id添加企业老师
     *
     * @param er 企业负责人信息对象，其中id为企业负责人id，其余字段为企业老师信息
     */
    void addTeacher(EnterpriseResponsibility er);

    /**
     * 修改企业负责人信息对象
     *
     * @param er 企业负责人信息对象
     */
    void updEr(EnterpriseResponsibility er);

    /**
     * 企业负责人修改企业老师信息
     *
     * @param er 企业负责人信息对象，其中erId为企业负责人id，
     *           id是企业老师id其余字段为企业老师信息
     */
    void updErTeacher(EnterpriseResponsibility er);

    /**
     * 经过企业负责人id删除企业id
     *
     * @param erId 企业负责人id
     * @param id   企业id
     */
    void deleteById(Long erId, Long id);

    /**
     * 根据查询条件查询企业老师信息
     *
     * @param queryCondition 信息查询条件
     * @return 查询到的信息实体对象
     */
    List<EnterpriseResponsibility> queryByCondition(EnpQueryModel queryCondition);
}
