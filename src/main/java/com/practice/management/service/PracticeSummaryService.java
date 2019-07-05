package com.practice.management.service;

import com.practice.management.bean.dto.AddTrainSummaryDto;
import com.practice.management.bean.dto.UpdStuTrainSummaryDto;
import com.practice.management.bean.entity.TrainSummary;
import com.practice.management.bean.model.TrainSummaryQueryModel;

import java.util.List;

public interface PracticeSummaryService {
    /**
     * 添加实训总结
     * 角色：学生
     *
     * @param summary 实训总结对象
     * @return 添加的结果
     */
    TrainSummary add(AddTrainSummaryDto summary);

    /**
     * 根据指定的实训总结id查询实训总结
     *
     * @param summaryId 实训总结
     * @return 实训总结对象
     */
    TrainSummary findById(Long summaryId);

    /**
     * 修改实训总结信息
     * 角色：学生
     *
     * @param dto 实训总结
     * @return 修改成功之后的实训总结对象
     */
    TrainSummary updateByStu(UpdStuTrainSummaryDto dto);

    /**
     * 删除实训总结信息
     * 角色：学生
     *
     * @param stuId     学生id
     * @param summaryId 实训总结id
     * @return 删除成功之后的实训总结对象
     */
    TrainSummary deleteById(Long stuId, Long summaryId);

    /**
     * 查询实训总结信息
     * 角色：学校负责人/老师和实训总结属于的当前的学生
     * 条件：学生学号、学校名称
     *
     * @param queryCondition 查询条件
     * @return 查询的实训总结信息列表
     */
    List<TrainSummary> queryByCondition(TrainSummaryQueryModel queryCondition);
}
