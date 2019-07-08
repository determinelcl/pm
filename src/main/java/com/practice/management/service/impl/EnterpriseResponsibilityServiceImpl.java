package com.practice.management.service.impl;

import com.practice.management.bean.dto.*;
import com.practice.management.bean.entity.Enterprise;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;
import com.practice.management.mapper.EnterpriseResponsibilityMapper;
import com.practice.management.service.AuthService;
import com.practice.management.service.EnterpriseResponsibilityService;
import com.practice.management.service.EnterpriseService;
import com.practice.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnterpriseResponsibilityServiceImpl implements EnterpriseResponsibilityService {

    @Autowired
    private EnterpriseResponsibilityMapper erMapper;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public void updEnterprise(UpdEnterpriseDto dto) {
        EnterpriseResponsibility er = findById(dto.getErId());
        if (er == null)
            throw new RuntimeException("企业负责人id:" + dto.getErId() + "不存在！");

        Long enterpriseId = er.getEnterpriseId();
        UpdEnterpriseParamDto enterprise = dto.getEnterprise();

        // 企业负责人的企业id应和修改的企业id相等
        if (!enterprise.getId().equals(enterpriseId))
            throw new RuntimeException("企业负责人:" + er.getName() + "不属于企业:" + enterprise.getName());

        // 验证企业的负责人是否可以修改企业信息
        Enterprise enp = enterpriseService.findById(enterpriseId);
        if (!enp.getAccount().equals(er.getAccount()))
            throw new RuntimeException("企业:" + enp.getName() + "的负责人不是:" + er.getName());

        enterpriseService.updateById(enterprise);
    }

    @Override
    public EnterpriseResponsibility findById(Long erId) {
        EnterpriseResponsibility er = erMapper.findById(erId);
        if (er == null)
            throw new RuntimeException("企业负责人id:" + erId + "不存在！");
        return er;
    }

    @Transactional
    @Override
    public void addTeacher(AddEnterpriseTeacherDto dto) {
        EnterpriseResponsibility enterpriseResponsibility = findById(dto.getErId());
        // 将添加的企业老师设置和企业负责人同样的id
        Long enterpriseId = enterpriseResponsibility.getEnterpriseId();
        dto.setEnterpriseId(enterpriseId);

        // 验证角色：企业老师的权限不可比企业负责人的权限高
        roleService.authorityValidate(enterpriseResponsibility.getRoleId(), dto.getRoleId());
        authService.register(dto);
    }

    @Transactional
    @Override
    public EnterpriseResponsibility updEr(UpdErDto dto) {
        EnterpriseResponsibility er = findById(dto.getErId());
        if (er == null)
            throw new RuntimeException("企业负责人id:" + dto.getErId() + "不存在");

        erMapper.updateErById(dto);
        return findById(dto.getErId());
    }

    @Transactional
    @Override
    public EnterpriseResponsibility updErTeacher(UpdEnterpriseTeacherDto dto) {
        validateErAndEt(dto.getErId(), dto.getEtId());

        // 验证角色：企业老师的权限不可比企业负责人的权限高
        roleService.authorityValidate(findById(dto.getErId()).getRoleId(), dto.getRoleId());
        erMapper.updateErTeacherById(dto);
        return findById(dto.getEtId());
    }

    /**
     * 验证企业负责人和企业老师是否同属于同一个企业
     *
     * @param erId 企业负责人id
     * @param etId 企业老师id
     * @return 企业老师信息
     */
    private EnterpriseResponsibility validateErAndEt(Long erId, Long etId) {
        EnterpriseResponsibility er = findById(erId);
        if (er == null)
            throw new RuntimeException("企业负责人id:" + erId + "不存在");

        EnterpriseResponsibility et = findById(etId);
        if (et == null)
            throw new RuntimeException("企业老师id:" + etId + "不存在");

        if (!er.getEnterpriseId().equals(et.getEnterpriseId()))
            throw new RuntimeException(
                    "企业负责人:" + er.getName() + "和企业老师:" + et.getName() + "不在同一个企业！");

        return et;
    }

    @Transactional
    @Override
    public EnterpriseResponsibility deleteById(Long erId, Long etId) {
        EnterpriseResponsibility et = validateErAndEt(erId, etId);
        erMapper.deleteById(etId);

        return et;
    }

    @Override
    public List<EnterpriseResponsibility> queryByCondition(EnpQueryModel queryCondition) {
        EnterpriseResponsibility er = findById(queryCondition.getErId());
        Enterprise enterprise = enterpriseService.findById(queryCondition.getEnpId());

        if (er.getEnterpriseId().equals(enterprise.getId()))
            throw new RuntimeException("企业负责人:" + er.getName() + "不属于企业:" + enterprise.getName());

        return erMapper.queryByCondition(queryCondition);
    }

    @Override
    public EnterpriseResponsibility validateErAuthority(Long erId) {
        EnterpriseResponsibility er = findById(erId);
        Enterprise enterprise = enterpriseService.findById(er.getEnterpriseId());

        if (!enterprise.getAccount().equals(er.getAccount()))
            throw new RuntimeException("企业:" + enterprise.getName() + "的负责人不是:" + er.getName());

        return er;
    }
}
