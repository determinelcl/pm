package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddMajorDto;
import com.practice.management.bean.dto.UpdMajorDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.MajorQueryModel;
import com.practice.management.mapper.MajorMapper;
import com.practice.management.service.MajorService;
import com.practice.management.service.SchoolResponsibilityService;
import com.practice.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private SchoolResponsibilityService srService;

    @Autowired
    private SchoolService schoolService;

    @Override
    public Major findById(Long majorId) {
        Major major = majorMapper.findById(majorId);
        if (major == null)
            throw new RuntimeException("专业id:" + majorId + "不存在");
        return major;
    }

    @Transactional
    @Override
    public Major add(AddMajorDto dto) {
        SchoolResponsibility sr = srService.findById(dto.getSrId());
        dto.setSchoolId(sr.getSchoolId());

        validateSr(dto.getSchoolId(), sr.getAccount(), sr.getName());
        validateUniqueMajor(dto.getName(), dto.getFacultyName());

        Long majorId = majorMapper.insert(dto);
        return majorMapper.findById(majorId);
    }

    private void validateUniqueMajor(String majorName, String facultyName) {
        List<Major> majorList = majorMapper.findByName(majorName, facultyName);
        if (majorList != null && majorList.size() > 0)
            throw new RuntimeException("学校的学院:" + facultyName + "已存在专业" + majorName);
    }

    private void validateSr(Long schoolId, String account, String srName) {
        School school = schoolService.findById(schoolId);
        if (!school.getResponsibility_account().equals(account))
            throw new RuntimeException("学校:" + school.getName() + "老师:" + srName + "没有添加专业的权限");
    }

    @Transactional
    @Override
    public Major update(UpdMajorDto dto) {
        validateSrAuthority(dto.getSrId(), dto.getMajorId());
        validateUniqueMajor(dto.getName(), dto.getFacultyName());

        majorMapper.updateById(dto);
        return majorMapper.findById(dto.getMajorId());
    }

    private Major validateSrAuthority(Long srId, Long majorId) {
        SchoolResponsibility sr = srService.findById(srId);
        Major major = findById(majorId);

        if (!major.getSchoolId().equals(sr.getSchoolId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "所在的学校没有开设专业:" + major.getName());

        validateSr(major.getSchoolId(), sr.getAccount(), sr.getName());
        return major;
    }

    @Transactional
    @Override
    public Major delete(Long srId, Long majorId) {
        Major major = validateSrAuthority(srId, majorId);

        majorMapper.deleteById(majorId);
        return major;
    }

    @Override
    public List<Major> query(MajorQueryModel queryCondition) {
        return majorMapper.queryByCondition(queryCondition);
    }
}
