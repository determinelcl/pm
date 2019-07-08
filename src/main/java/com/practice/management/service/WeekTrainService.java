package com.practice.management.service;

import com.practice.management.bean.dto.AddWtDto;
import com.practice.management.bean.dto.UpdWtDto;
import com.practice.management.bean.entity.WeekTrain;
import com.practice.management.bean.model.WtQueryModel;

import java.util.List;

public interface WeekTrainService {
    /**
     * 添加每周的实训情况
     * 角色：企业负责人
     *
     * @param dto 每周实训dto
     * @return 添加成功的每周实训对象
     */
    WeekTrain add(AddWtDto dto);

    /**
     * 根据id查询每周实训
     *
     * @param wtId 每周实训id
     * @return 每周实训独对象
     */
    WeekTrain findById(Long wtId);

    /**
     * 修改每周的实训情况
     * 角色：企业负责人
     *
     * @param dto 每周实训dto
     * @return 修改完成的每周实训对象
     */
    WeekTrain update(UpdWtDto dto);

    /**
     * 根据id删除每周的实训情况
     * 角色：企业负责人
     *
     * @param erId 企业负责人id
     * @param wtId 每周实训对象id
     * @return 删除成功的每周实训对象
     */
    WeekTrain delete(Long erId, Long wtId);

    /**
     * 查询每周的实训情况
     * 角色：企业负责人/老师、学校负责人/老师、学生
     *
     * @param queryCondition 查询条件
     * @return 查询到的每周实训对象列表
     */
    List<WeekTrain> query(WtQueryModel queryCondition);
}
