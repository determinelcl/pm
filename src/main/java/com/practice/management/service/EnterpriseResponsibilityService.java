package com.practice.management.service;

import com.practice.management.bean.dto.AddEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdEnterpriseDto;
import com.practice.management.bean.dto.UpdEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdErDto;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;

import java.util.List;

public interface EnterpriseResponsibilityService {
    /**
     * 企业负责人修改企业信息
     *
     * @param dto 修改企业数据的dto
     */
    void updEnterprise(UpdEnterpriseDto dto);

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
     * @param dto 企业负责人信息对象，其中id为企业负责人id，其余字段为企业老师信息
     */
    void addTeacher(AddEnterpriseTeacherDto dto);

    /**
     * 修改企业负责人信息对象
     *
     * @param dto 企业负责人信息对象
     * @return 修改之后的企业负责人信息
     */
    EnterpriseResponsibility updEr(UpdErDto dto);

    /**
     * 企业负责人修改企业老师信息
     *
     * @param dto 修改的企业老师的信息对象
     * @return 更新后的企业老师信息
     */
    EnterpriseResponsibility updErTeacher(UpdEnterpriseTeacherDto dto);

    /**
     * 经过企业负责人id删除企业id
     *
     * @param erId 企业负责人id
     * @param etId 企业老师id
     * @return 删除的企业老师信息
     */
    EnterpriseResponsibility deleteById(Long erId, Long etId);

    /**
     * 根据查询条件查询企业老师信息
     *
     * @param queryCondition 信息查询条件
     * @return 查询到的信息实体对象
     */
    List<EnterpriseResponsibility> queryByCondition(EnpQueryModel queryCondition);

    /**
     * 验证企业负责人是否正确
     *
     * @param erId 企业负责人id
     * @return 验证通过返回企业负责人信息
     */
    EnterpriseResponsibility validateErAuthority(Long erId);

    /**
     * 根据企业id和账号查询企业负责人/老师信息
     *
     * @param eId     企业id
     * @param account 企业负责人/老师账号
     * @return 企业负责人/老师个人信息
     */
    EnterpriseResponsibility findByEcIdAndAccount(Long eId, String account);
}
