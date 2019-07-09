package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddEmploymentDto;
import com.practice.management.bean.dto.UpdEmploymentDto;
import com.practice.management.bean.entity.Employment;
import com.practice.management.bean.entity.Student;
import com.practice.management.bean.model.EmploymentQueryModel;
import com.practice.management.mapper.EmploymentStatisticMapper;
import com.practice.management.service.EmploymentStatisticService;
import com.practice.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EmploymentStatisticServiceImpl implements EmploymentStatisticService {

    @Autowired
    private EmploymentStatisticMapper statisticMapper;

    @Autowired
    private StudentService studentService;

    @Transactional
    @Override
    public Employment add(AddEmploymentDto dto) {
        Student student = studentService.findById(dto.getStuId());
        Employment employment = statisticMapper.findByStudentId(dto.getStuId());
        if (employment != null)
            throw new RuntimeException("已添加就业统计记录，不可重复添加");

        if (!student.getEnterpriseId().equals(dto.getEnterpriseId()))
            throw new RuntimeException("学生和企业没有实训的关联关系");

        dto.setAddTime(new Date());
        statisticMapper.insert(dto);
        return statisticMapper.findById(dto.getId());
    }

    @Override
    public Employment findById(Long eId) {
        Employment employment = statisticMapper.findById(eId);
        if (employment == null)
            throw new RuntimeException("就业统计id:" + eId + "不存在");

        return employment;
    }

    @Override
    public Employment update(UpdEmploymentDto dto) {
        studentService.findById(dto.getStuId());
        Employment employment = findById(dto.getEId());
        if (!employment.getStudentId().equals(dto.getStuId()))
            throw new RuntimeException("学生id:" + dto.getStuId() + "没有就业统计id:" + dto.getEId() + "的操作权限");

        statisticMapper.updateById(dto);
        return statisticMapper.findById(dto.getEId());
    }

    @Override
    public List<Employment> query(EmploymentQueryModel queryCondition) {

        return statisticMapper.queryByCondition(queryCondition);
    }
}
