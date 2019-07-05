package com.practice.management.service.impl;

import com.practice.management.bean.entity.Coefficient;
import com.practice.management.mapper.CoefficientMapper;
import com.practice.management.service.CoefficientService;
import com.practice.management.service.EnterpriseResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoefficientServiceImpl implements CoefficientService {

    @Autowired
    private CoefficientMapper coefficientMapper;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Override
    public Coefficient findById(Long cId) {
        Coefficient coefficient = coefficientMapper.findById(cId);
        if (coefficient == null)
            throw new RuntimeException("实习成绩阶段系数id:" + cId + "不存在");
        return coefficient;
    }

    @Override
    public Coefficient addByErId(Coefficient coefficient, Long erId) {
        erService.findById(erId);

        Long cId = coefficientMapper.insert(coefficient);
        coefficient.setId(cId);

        return coefficient;
    }
}
