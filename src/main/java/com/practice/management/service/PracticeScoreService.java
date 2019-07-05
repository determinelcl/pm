package com.practice.management.service;

import com.practice.management.bean.dto.AddTsDto;
import com.practice.management.bean.dto.UpdTsDto;
import com.practice.management.bean.entity.TrainScore;
import com.practice.management.bean.model.TsQueryModel;

import java.util.List;

public interface PracticeScoreService {

    /**
     * 添加学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param dto 实训成绩dto
     * @return 添加完成的实训成绩对象
     */
    TrainScore add(AddTsDto dto);

    /**
     * 根据id查询实训成绩
     *
     * @param tsId 实训成绩id
     * @return 实训成绩对象
     */
    TrainScore findById(Long tsId);

    /**
     * 修改学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param dto 实训成绩dto
     * @return 修改完成的实训成绩对象
     */
    TrainScore update(UpdTsDto dto);

    /**
     * 删除学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param erId 企业负责人/老师id
     * @param tsId 实训成绩id
     * @return 添加完成的实训成绩对象
     */
    TrainScore deleteById(Long erId, Long tsId);

    /**
     * 查询学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param queryCondition 查询条件的模型对象
     * @return 符合条件的实训成绩对象
     */
    List<TrainScore> query(TsQueryModel queryCondition);
}
