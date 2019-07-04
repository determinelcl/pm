package com.practice.management.service.impl;

import com.practice.management.bean.entity.Major;
import com.practice.management.mapper.MajorMapper;
import com.practice.management.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Major findById(Long majorId) {
        Major major = majorMapper.findById(majorId);
        if (major == null)
            throw new RuntimeException("专业id:" + majorId + "不存在");
        return major;
    }
}
