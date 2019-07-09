package com.practice.management.controller;

import com.alibaba.fastjson.JSON;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
     * @param file 上传的任务书文件
     * @return 添加的结果
     */
    @PostMapping("/add")
    public ResultModel<Task> add(@Valid @RequestParam("data") String task, MultipartFile file) {
        if (file == null)
            return error("文件不能为空");

        AddTaskDto taskDto = JSON.parseObject(task, AddTaskDto.class);
        taskDto.setEnclosureFile(file);
        Task rs = taskBookService.add(taskDto);
        return success(rs);
    }

    /**
     * 修改任务书信息
     * 角色：学生
     *
     * @param task 任务书
     * @param file 上传的任务书文件
     * @return 修改成功之后的任务书对象
     */
    @PutMapping("/upd/stu")
    public ResultModel<Task> updateByStu(@Valid @RequestParam("data") String task, MultipartFile file) {
        UpdStuTaskDto dto = JSON.parseObject(task, UpdStuTaskDto.class);
        dto.setEnclosureFile(file);
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
    public ResultModel<Task> updateBySr(@Valid @RequestBody UpdSrTaskDto dto) {
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
    public ResultModel<Task> updateEr(@Valid @RequestBody UpdErTaskDto dto) {
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
    @DeleteMapping("/del/{stuId:\\d+}/{taskId:\\d+}")
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
    @PostMapping("/query")
    public ResultModel<List<Task>> query(@Valid @RequestBody TaskQueryModel queryCondition) {
        List<Task> list = taskBookService.queryByCondition(queryCondition);
        return success(list);
    }
}
