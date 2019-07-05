package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddTsDto;
import com.practice.management.bean.dto.UpdTsDto;
import com.practice.management.bean.entity.*;
import com.practice.management.bean.model.TsQueryModel;
import com.practice.management.mapper.PracticeScoreMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeScoreServiceImpl implements PracticeScoreService {

    @Autowired
    private PracticeScoreMapper scoreMapper;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CoefficientService coefficientServices;

    @Autowired
    private SchoolEnterpriseService seService;

    @Autowired
    private EnterpriseProgrammeService epService;


    @Override
    public TrainScore add(AddTsDto dto) {
        Long erId = dto.getErId();
        EnterpriseResponsibility er = erService.findById(erId);
        dto.setEnterpriseId(er.getEnterpriseId());

        // 设置实训成绩的实训成绩阶段系数id
        if (dto.getCoefficientId() == null)
            dto.setCoefficientId(coefficientServices.addByErId(dto.getCoefficient(), dto.getErId()).getId());
        else
            coefficientServices.findById(dto.getCoefficientId());

        // 验证学校是否开设对应的专业
        Major major = majorService.findById(dto.getMajorId());
        if (!major.getSchoolId().equals(dto.getSchoolId()))
            throw new RuntimeException("学校没有开设专业：" + major.getName());

        // 验证学生的专业是否正确
        Student student = studentService.findById(dto.getStudentId());
        if (!student.getMajorId().equals(major.getId()))
            throw new RuntimeException("学生:" + student.getName() + "不是专业:" + major.getName() + "的学生");

        // 验证学校和企业是否进行了校企合作
        Long enterpriseId = dto.getEnterpriseId();
        seService.findByScIdAndEnpId(major.getSchoolId(), enterpriseId);

        // 验证企业是否开设了企业的课程
        Long enterpriseProgrammeId = dto.getEnterpriseProgrammeId();
        validateEpAuthority(enterpriseId, enterpriseProgrammeId);

        Long tsId = scoreMapper.insert(dto);
        return scoreMapper.findById(tsId);
    }

    /**
     * 验证企业是否开设了相关的企业课程
     *
     * @param enterpriseId 企业id
     * @param epId 企业课程id
     */
    private void validateEpAuthority(Long enterpriseId, Long epId) {
        EnterpriseProgramme ep = epService.findById(epId);
        if (enterpriseId.equals(ep.getEnterpriseId()))
            throw new RuntimeException("企业id" + ep.getEnterpriseId() + "未开设企业课程：" + ep.getName());
    }

    @Override
    public TrainScore findById(Long tsId) {
        TrainScore trainScore = scoreMapper.findById(tsId);
        if (trainScore == null)
            throw new RuntimeException("实训成绩id:" + tsId + "不存在");
        return trainScore;
    }

    @Override
    public TrainScore update(UpdTsDto dto) {
        Long tsId = dto.getTsId();
        Long erId = dto.getErId();

        TrainScore trainScore = validateTrainScoreAuthority(erId, tsId);

        coefficientServices.findById(dto.getCoefficientId());
        validateEpAuthority(trainScore.getEnterpriseId(), dto.getEnterpriseProgrammeId());

        scoreMapper.updateById(dto);
        return scoreMapper.findById(tsId);
    }

    /**
     * 验证企业对实训成绩是否具有操作权限
     *
     * @param erId 企业负责人/老师id
     * @param tsId 实训成绩id
     * @return 实训成绩对象
     */
    private TrainScore validateTrainScoreAuthority(Long erId, Long tsId) {
        EnterpriseResponsibility er = erService.findById(erId);

        TrainScore trainScore = findById(tsId);
        if (!trainScore.getEnterpriseId().equals(er.getEnterpriseId()))
            throw new RuntimeException(
                    "企业:" + er.getEnterpriseId() + "没有实训成绩:" + trainScore.getId() + "的操作权限");

        return trainScore;
    }

    @Override
    public TrainScore deleteById(Long erId, Long tsId) {
        TrainScore trainScore = validateTrainScoreAuthority(erId, tsId);

        scoreMapper.deleteById(tsId);
        return trainScore;
    }

    @Override
    public List<TrainScore> query(TsQueryModel queryCondition) {

        return scoreMapper.queryByCondition(queryCondition);
    }
}
