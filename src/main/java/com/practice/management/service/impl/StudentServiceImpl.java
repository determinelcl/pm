package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.entity.Student;
import com.practice.management.mapper.StudentMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AuthService authService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private EnterpriseProgrammeService programmeService;

    @Override
    public Student addStudent(AddStudentDto dto, Long schoolId) {
        Long enterpriseId = dto.getEnterpriseId();
        Long majorId = dto.getMajorId();
        Long enterpriseProgrammeId = dto.getEnterpriseProgrammeId();

        // 验证是否存在
        enterpriseService.findById(enterpriseId);
        Major major = majorService.findById(majorId);
        if (!major.getSchoolId().equals(schoolId))
            throw new RuntimeException("学校id:" + schoolId + "没有开设专业id:" + majorId);

        programmeService.findById(enterpriseProgrammeId);

        authService.register(dto);
        return studentMapper.findByAccountAndMajorId(dto.getAccount(), dto.getMajorId());
    }
}
