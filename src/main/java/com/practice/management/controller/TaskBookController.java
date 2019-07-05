package com.practice.management.controller;

import com.practice.management.bean.dto.AddTaskDto;
import com.practice.management.bean.dto.UpdErTaskDto;
import com.practice.management.bean.dto.UpdSrTaskDto;
import com.practice.management.bean.dto.UpdStuTaskDto;
import com.practice.management.bean.entity.Task;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.TaskQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.TaskBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 任务书：CURD操作，操作表单
 * 角色：学生：CURD，
 * 老师：审核 后
 * 企业：企业意见 先
 */
@RestController
@RequestMapping("/tb")
public class TaskBookController extends BaseController {

    @Autowired
    private TaskBookService taskBookService;

    /**
     * 添加任务书
     * 角色：学生
     *
     * @param task 任务书对象
     * @return 添加的结果
     */
    public ResultModel<Task> add(@RequestBody AddTaskDto task) {
        Task rs = taskBookService.add(task);
        return success("添加成功", rs);
    }

    /**
     * 修改任务书信息
     * 角色：学生
     *
     * @param dto 任务书
     * @return 修改成功之后的任务书对象
     */
    @PutMapping("/upd/stu")
    public ResultModel<Task> updateByStu(@RequestBody UpdStuTaskDto dto) {
        Task mr = taskBookService.updateByStu(dto);
        return success(mr);
    }

    /**
     * 学校修审核任务书
     * 角色：学校负责人
     *
     * @param dto 任务书
     * @return 审核的任务书对象
     */
    @PutMapping("/upd/sr")
    public ResultModel<Task> updateBySr(@RequestBody UpdSrTaskDto dto) {
        Task mr = taskBookService.updateBySr(dto);
        return success(mr);
    }

    /**
     * 企业填写任务书意见
     * 角色：企业负责人
     *
     * @param dto 任务书
     * @return 修改成功之后的任务书对象
     */
    @PutMapping("/upd/er")
    public ResultModel<Task> updateEr(@RequestBody UpdErTaskDto dto) {
        Task mr = taskBookService.updateByEr(dto);
        return success(mr);
    }

    /**
     * 删除任务书信息
     * 角色：学生
     *
     * @param stuId  学生id
     * @param taskId 任务书id
     * @return 删除成功之后的任务书对象
     */
    @PutMapping("/del/{stuId:\\d+}/{taskId:\\d+}")
    public ResultModel<Task> delete(
            @PathVariable("stuId") Long stuId, @PathVariable("taskId") Long taskId) {
        Task mr = taskBookService.deleteById(stuId, taskId);
        return success(mr);
    }

    /**
     * 查询任务书信息
     * 角色：所有登录用户和任务书属于的当前的学生
     * 条件：学生学号、任务书项目名称、提交时间、学校名称、企业name
     *
     * @param queryCondition 查询条件
     * @return 查询的任务书信息列表
     */
    @PutMapping("/query")
    public ResultModel<List<Task>> query(@RequestBody TaskQueryModel queryCondition) {
        List<Task> list = taskBookService.queryByCondition(queryCondition);
        return success(list);
    }
}
