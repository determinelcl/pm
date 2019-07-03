package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdEnterpriseDto;
import com.practice.management.bean.dto.UpdEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdErDto;
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
    public void updEnterprise(UpdEnterpriseDto dto) {
        EnterpriseResponsibility er = findById(dto.getErId());
        Long enterpriseId = er.getEnterpriseId();
        Enterprise enterprise = dto.getEnterprise();

        // 企业负责人的企业id应和修改的企业id相等
        if (!enterprise.getId().equals(enterpriseId))
            throw new RuntimeException("企业负责人:" + er.getName() + "不属于企业:" + enterprise.getName());

        enterpriseService.updateById(enterprise);
    }

    @Override
    public EnterpriseResponsibility findById(Long erId) {
        EnterpriseResponsibility er = erMapper.findById(erId);
        if (er == null)
            throw new RuntimeException("企业负责人id:" + erId + "不存在！");
        return er;
    }

    @Override
    public void addTeacher(AddEnterpriseTeacherDto dto) {
        EnterpriseResponsibility enterpriseResponsibility = findById(dto.getErId());
        // 将添加的企业老师设置和企业负责人同样的id
        Long enterpriseId = enterpriseResponsibility.getEnterpriseId();
        dto.setEnterpriseId(enterpriseId);

        erMapper.insert(dto);
    }

    @Override
    public EnterpriseResponsibility updEr(UpdErDto dto) {
        EnterpriseResponsibility er = findById(dto.getErId());
        if (er == null)
            throw new RuntimeException("企业负责人id:" + dto.getErId() + "不存在");

        erMapper.updateErById(dto);
        return findById(dto.getErId());
    }

    @Override
    public EnterpriseResponsibility updErTeacher(UpdEnterpriseTeacherDto dto) {
        validateErAndEt(dto.getEtId(), dto.getEtId());
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
}
