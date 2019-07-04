package com.practice.management.service.impl;

import com.practice.management.bean.entity.SchoolEnterprise;
import com.practice.management.mapper.SchoolEnterpriseMapper;
import com.practice.management.service.SchoolEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolEnterpriseServiceImpl implements SchoolEnterpriseService {

    @Autowired
    private SchoolEnterpriseMapper seMapper;

    @Override
    public SchoolEnterprise findByScIdAndEnpId(Long scId, Long enpId) {
        SchoolEnterprise se = seMapper.findByScIdAndEnpId(scId, enpId);
        if (se == null)
            throw new RuntimeException("学校id:" + scId + "和企业id:" + enpId + "不存在！");

        return se;
    }
}
