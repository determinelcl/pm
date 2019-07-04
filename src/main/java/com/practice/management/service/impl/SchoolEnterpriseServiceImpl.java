package com.practice.management.service.impl;

import com.practice.management.bean.entity.Enterprise;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolEnterprise;
import com.practice.management.mapper.SchoolEnterpriseMapper;
import com.practice.management.service.EnterpriseService;
import com.practice.management.service.SchoolEnterpriseService;
import com.practice.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolEnterpriseServiceImpl implements SchoolEnterpriseService {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private SchoolEnterpriseMapper seMapper;

    @Override
    public SchoolEnterprise findByScIdAndEnpId(Long scId, Long enpId) {
        School school = schoolService.findById(scId);
        Enterprise enterprise = enterpriseService.findById(enpId);

        SchoolEnterprise se = seMapper.findByScIdAndEnpId(scId, enpId);
        if (se == null)
            throw new RuntimeException("学校:" + school.getName() + "和企业:" + enterprise.getName() + "不存在校企合作！");

        return se;
    }
}
