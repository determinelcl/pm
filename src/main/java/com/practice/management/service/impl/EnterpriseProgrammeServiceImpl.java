package com.practice.management.service.impl;

import com.practice.management.bean.entity.EnterpriseProgramme;
import com.practice.management.mapper.EnterpriseProgrammeMapper;
import com.practice.management.service.EnterpriseProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProgrammeServiceImpl implements EnterpriseProgrammeService {

    @Autowired
    private EnterpriseProgrammeMapper programmeMapper;

    @Override
    public EnterpriseProgramme findById(Long programmeId) {
        EnterpriseProgramme programme = programmeMapper.findById(programmeId);
        if (programme == null)
            throw new RuntimeException("企业培训方案id:" + programmeId + "不存在！");

        return programme;
    }
}
