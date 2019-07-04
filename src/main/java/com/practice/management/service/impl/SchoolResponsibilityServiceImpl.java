package com.practice.management.service.impl;

import com.practice.management.bean.dto.*;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.SchoolQueryModel;
import com.practice.management.mapper.SchoolResponsibilityMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolResponsibilityServiceImpl implements SchoolResponsibilityService {

    @Autowired
    private SchoolResponsibilityMapper srMapper;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private AuthService authService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolEnterpriseService seService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public School updSchool(UpdSchoolDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = findById(srId);

        Long schoolId = sr.getSchoolId();
        UpdSchoolParamDto school = dto.getSchool();
        if (!schoolId.equals(school.getId()))
            throw new RuntimeException("企业负责人:" + sr.getName() + "不属于企业:" + school.getName());

        return schoolService.updateById(school);
    }

    @Override
    public SchoolResponsibility findById(Long srId) {
        SchoolResponsibility sr = srMapper.findById(srId);
        if (sr == null)
            throw new RuntimeException("学校负责人id:" + srId + "不存在！");
        return sr;
    }

    @Transactional
    @Override
    public void addStudent(AddStudentDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = findById(srId);
        // 验证校企合作
        seService.findByScIdAndEnpId(sr.getSchoolId(), dto.getEnterpriseId());

        // 验证角色：学校学生的权限不可比老师的权限高
        roleService.authorityValidate(sr.getRoleId(), dto.getRoleId());
        studentService.addStudent(dto, sr.getSchoolId());
    }

    @Transactional
    @Override
    public void addSchoolTeacher(AddSchoolTeacherDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = findById(srId);
        dto.setSchoolId(sr.getSchoolId());

        // 验证角色：学校老师的权限不可比学校负责人的权限高
        roleService.authorityValidate(sr.getRoleId(), dto.getRoleId());
        authService.register(dto);
    }

    @Transactional
    @Override
    public SchoolResponsibility updateSr(UpdSrDto dto) {
        findById(dto.getSrId());
        srMapper.updateSrById(dto);

        return findById(dto.getSrId());
    }

    @Transactional
    @Override
    public SchoolResponsibility updSrTeacher(UpdSchoolTeacherDto dto) {
        validateSrAndSt(dto.getSrId(), dto.getStId());

        // 验证角色：学校老师的权限不可比学校负责人的权限高
        roleService.authorityValidate(findById(dto.getSrId()).getRoleId(), dto.getRoleId());

        srMapper.updateSrTeacherById(dto);
        return findById(dto.getStId());
    }

    /**
     * 验证企业负责人和企业老师是否同属于同一个企业
     *
     * @param srId 企业负责人id
     * @param stId 企业老师id
     * @return 企业老师信息
     */
    private SchoolResponsibility validateSrAndSt(Long srId, Long stId) {
        SchoolResponsibility sr = findById(srId);
        if (sr == null)
            throw new RuntimeException("学校负责人id:" + srId + "不存在");

        SchoolResponsibility st = findById(stId);
        if (st == null)
            throw new RuntimeException("学校老师id:" + stId + "不存在");

        if (!sr.getSchoolId().equals(st.getSchoolId()))
            throw new RuntimeException(
                    "学校负责人:" + sr.getName() + "和企业老师:" + st.getName() + "不在同一个学校！");

        return st;
    }

    @Transactional
    @Override
    public SchoolResponsibility deleteById(Long srId, Long stId) {
        SchoolResponsibility st = validateSrAndSt(srId, stId);
        srMapper.deleteById(stId);

        return st;
    }

    @Override
    public List<SchoolResponsibility> queryByCondition(SchoolQueryModel queryCondition) {
        SchoolResponsibility sr = findById(queryCondition.getSrId());
        School school = schoolService.findById(queryCondition.getSchoolId());

        if (sr.getSchoolId().equals(school.getId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "不属于学校:" + school.getName());

        return srMapper.queryByCondition(queryCondition);
    }

}
