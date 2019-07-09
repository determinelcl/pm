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

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EnterpriseService enterpriseService;


    @Override
    public TrainScore add(AddTsDto dto) {
        Long erId = dto.getErId();
        EnterpriseResponsibility er = erService.findById(erId);

        // 设置实训成绩的实训成绩阶段系数id
        if (dto.getCoefficientId() == null)
            dto.setCoefficientId(coefficientServices.addByErId(dto.getCoefficient(), dto.getErId()).getId());
        else
            coefficientServices.findById(dto.getCoefficientId());

        // 验证学生的专业是否正确
        Student student = studentService.findById(dto.getStudentId());
        // 验证学校是否开设对应的专业
        Major major = majorService.findById(student.getMajorId());

        // 验证企业是否开设了企业的课程
        EnterpriseProgramme ep = epService.findById(dto.getEnterpriseProgrammeId());

        if (!er.getEnterpriseId().equals(ep.getEnterpriseId()))
            throw new RuntimeException("企业老师所在的企业没有开设企业课程");

        // 验证学校和企业是否进行了校企合作
        seService.findByScIdAndEnpId(major.getSchoolId(), ep.getEnterpriseId());


        scoreMapper.insert(dto);
        return scoreMapper.findById(dto.getId());
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

        validateTrainScoreAuthority(erId, tsId);
        coefficientServices.findById(dto.getCoefficientId());

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

        EnterpriseProgramme enterpriseProgramme = epService.findById(trainScore.getEnterpriseProgrammeId());
        if (!enterpriseProgramme.getEnterpriseId().equals(er.getEnterpriseId()))
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
