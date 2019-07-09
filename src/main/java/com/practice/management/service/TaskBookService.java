package com.practice.management.service;

import com.practice.management.bean.dto.AddTaskDto;
import com.practice.management.bean.dto.UpdErTaskDto;
import com.practice.management.bean.dto.UpdSrTaskDto;
import com.practice.management.bean.dto.UpdStuTaskDto;
import com.practice.management.bean.entity.Task;
import com.practice.management.bean.model.TaskQueryModel;

import java.util.List;

public interface TaskBookService {
    /**
     * 添加任务书
     * 角色：学生
     *
     * @param dto 任务书对象
     * @return 添加的结果
     */
    Task add(AddTaskDto dto);

    /**
     * 根据指定id查询任务书
     *
     * @param taskId 任务书id
     * @return 任务书对象
     */
    Task findById(Long taskId);

    /**
     * 修改任务书信息
     * 角色：学生
     *
     * @param dto 任务书
     * @return 修改成功之后的任务书对象
     */
    Task updateByStu(UpdStuTaskDto dto);

    /**
     * 学校修审核任务书
     * 角色：学校负责人
     *
     * @param dto 任务书
     * @return 审核的任务书对象
     */
    Task updateBySr(UpdSrTaskDto dto);

    /**
     * 企业填写任务书意见
     * 角色：企业负责人
     *
     * @param dto 任务书
     * @return 修改成功之后的任务书对象
     */
    Task updateByEr(UpdErTaskDto dto);

    /**
     * 删除任务书信息
     * 角色：学生
     *
     * @param stuId  学生id
     * @param taskId 任务书id
     * @return 删除成功之后的任务书对象
     */
    Task deleteById(Long stuId, Long taskId);

    /**
     * 查询任务书信息
     * 角色：所有登录用户和任务书属于的当前的学生
     * 条件：学生学号、提交时间、学校名称、企业name
     *
     * @param queryCondition 查询条件
     * @return 查询的任务书信息列表
     */
    List<Task> queryByCondition(TaskQueryModel queryCondition);
}
