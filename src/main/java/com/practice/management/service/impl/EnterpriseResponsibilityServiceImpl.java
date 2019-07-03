package com.practice.management.service.impl;

import com.practice.management.bean.entity.Enterprise;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;
import com.practice.management.mapper.EnterpriseResponsibilityMapper;
import com.practice.management.service.EnterpriseResponsibilityService;
import com.practice.management.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseResponsibilityServiceImpl implements EnterpriseResponsibilityService {

    @Autowired
    private EnterpriseResponsibilityMapper erMapper;

    @Autowired
    private EnterpriseService enterpriseService;

    @Override
    public void updEnterprise(EnterpriseResponsibility er) {
        findById(er.getId());
        // 企业老师是不可以修改企业的

        Enterprise enterprise = er.getEnterprise();
        enterpriseService.updateById(enterprise);
    }

    @Override
    public EnterpriseResponsibility findById(Long erId) {
        EnterpriseResponsibility rs = erMapper.findById(erId);
        if (rs == null)
            throw new RuntimeException("企业负责人id：" + erId + "不存在！");
        return rs;
    }

    @Override
    public void addTeacher(EnterpriseResponsibility er) {
        findById(er.getId());
        erMapper.insert(er);
    }

    @Override
    public void updEr(EnterpriseResponsibility er) {
        findById(er.getId());
        erMapper.updateErById(er);
    }

    @Override
    public void updErTeacher(EnterpriseResponsibility er) {
        findById(er.getErId());
        findById(er.getId());
        erMapper.updateErTeacherById(er);
    }

    @Override
    public void deleteById(Long erId, Long id) {
        findById(erId);
        findById(id);
        erMapper.deleteById(id);
    }

    @Override
    public List<EnterpriseResponsibility> queryByCondition(EnpQueryModel queryCondition) {
        EnterpriseResponsibility er = findById(queryCondition.getErId());
        Enterprise enterprise = enterpriseService.findById(queryCondition.getEnpId());

        if (er.getEnterpriseId().equals(enterprise.getId()))
            throw new RuntimeException("企业id和企业负责人id不同！");

        return erMapper.queryByCondition(queryCondition);
    }
}
