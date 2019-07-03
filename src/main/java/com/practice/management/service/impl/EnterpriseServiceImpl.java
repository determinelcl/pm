package com.practice.management.service.impl;

import com.practice.management.bean.entity.Enterprise;
import com.practice.management.mapper.EnterpriseMapper;
import com.practice.management.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public Enterprise add(Enterprise enterprise) {
        Enterprise temp = enterpriseMapper.findByName(enterprise.getName());
        if (temp != null)
            throw new RuntimeException("企业：" + enterprise.getName() + "已存在！");

        enterprise.setAddTime(new Date());
        enterprise.setRemarks("");
        enterpriseMapper.insert(enterprise);

        return enterpriseMapper.findByName(enterprise.getName());
    }

    @Override
    public Enterprise findById(Long enpId) {
        Enterprise enterprise = enterpriseMapper.findById(enpId);
        if (enterprise == null)
            throw new RuntimeException("企业：" + enpId + "不存在");
        return enterprise;
    }
}
