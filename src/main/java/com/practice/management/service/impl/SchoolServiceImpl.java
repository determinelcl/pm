package com.practice.management.service.impl;

import com.practice.management.bean.entity.School;
import com.practice.management.mapper.SchoolMapper;
import com.practice.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public School add(School school) {
        School temp = schoolMapper.findByName(school.getName());
        if (temp != null)
            throw new RuntimeException("学校：" + school.getName() + "已存在！");

        school.setAddTime(new Date());
        school.setRemarks("");
        schoolMapper.insert(school);

        return schoolMapper.findByName(school.getName());
    }

    @Override
    public School findById(Long schoolId) {
        School school = schoolMapper.findById(schoolId);

        if (school == null)
            throw new RuntimeException("学校：" + schoolId + "不存在");

        return school;
    }
}
