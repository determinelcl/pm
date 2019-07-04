package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.dto.UpdSrStudentDto;
import com.practice.management.bean.dto.UpdStudentDto;
import com.practice.management.bean.entity.*;
import com.practice.management.mapper.StudentMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private SchoolResponsibilityService srService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolEnterpriseService seService;

    @Transactional
    @Override
    public Student addStudent(AddStudentDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = srService.findById(srId);
        // 验证校企合作
        seService.findByScIdAndEnpId(sr.getSchoolId(), dto.getEnterpriseId());

        // 验证角色：学校学生的权限不可比老师的权限高
        roleService.authorityValidate(sr.getRoleId(), dto.getRoleId());

        return addStudent(dto, sr.getSchoolId());
    }


    private Student addStudent(AddStudentDto dto, Long schoolId) {
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


    @Override
    public Student findById(Long stuId) {
        Student student = studentMapper.findById(stuId);
        if (student == null)
            throw new RuntimeException("学生id:" + stuId + "不存在！");
        return student;
    }

    @Transactional
    @Override
    public Student updStudent(UpdStudentDto dto) {
        Long stuId = dto.getStuId();
        findById(stuId);

        studentMapper.updStudentById(dto);
        return findById(stuId);
    }

    @Transactional
    @Override
    public Student updStudentBySr(UpdSrStudentDto dto) {
        // 验证学生是否存在
        Long stuId = dto.getStuId();
        findById(stuId);

        // 验证学校老师是否存在
        Long srId = dto.getSrId();
        SchoolResponsibility sr = srService.findById(srId);
        Long schoolId = sr.getSchoolId();

        // 验证专业是否存在
        Long majorId = dto.getMajorId();
        Major major = majorService.findById(majorId);
        Long majorSchoolId = major.getSchoolId();

        // 验证学校是否开设选定的专业
        School school = schoolService.findById(schoolId);
        String schoolName = school.getName();
        if (schoolId.equals(majorSchoolId))
            throw new RuntimeException("学校:" + schoolName + "没有开设专业:" + major.getName());

        // 验证校企合作
        Long enterpriseId = dto.getEnterpriseId();
        seService.findByScIdAndEnpId(schoolId, enterpriseId);

        // 验证企业开设的方向
        Enterprise enterprise = enterpriseService.findById(enterpriseId);
        EnterpriseProgramme programme = programmeService.findById(dto.getEnterpriseProgrammeId());
        if (programme.getEnterpriseId().equals(enterpriseId))
            throw new RuntimeException("企业:" + enterprise.getName() + "不存在企业课程:" + programme.getName());

        // 验证角色：学校学生的权限不可比老师的权限高
        roleService.authorityValidate(sr.getRoleId(), dto.getRoleId());

        studentMapper.updStudentBySr(dto);
        return findById(dto.getStuId());
    }
}
