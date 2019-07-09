package com.practice.management.controller;

import com.practice.management.bean.dto.UpdErMReportDto;
import com.practice.management.bean.dto.UpdSrMReportDto;
import com.practice.management.bean.dto.UpdStuMReportDto;
import com.practice.management.bean.entity.MonthReport;
import com.practice.management.bean.model.MonthlyReportQueryModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MonthlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 月报：CURD
 * 角色：学生：CURD
 * 老师：审核
 * 企业：意见
 */
@RestController
@RequestMapping("/mr")
public class MonthlyReportController extends BaseController {

    @Autowired
    private MonthlyReportService monthlyReportService;

    /**
     * 添加月报信息
     * 角色：学生
     *
     * @param monthReport 月报
     * @return 添加成功之后的月报对象
     */
    @PostMapping("/add")
    public ResultModel<MonthReport> add(@Valid @RequestBody MonthReport monthReport) {
        MonthReport mr = monthlyReportService.add(monthReport);
        return success(mr);
    }

    /**
     * 修改月报信息
     * 角色：学生
     *
     * @param dto 月报
     * @return 修改成功之后的月报对象
     */
    @PutMapping("/upd/stu")
    public ResultModel<MonthReport> updateByStu(@Valid @RequestBody UpdStuMReportDto dto) {
        MonthReport mr = monthlyReportService.updateByStu(dto);
        return success(mr);
    }

    /**
     * 学校修审核月报
     * 角色：学校负责人
     *
     * @param dto 月报
     * @return 审核的月报对象
     */
    @PutMapping("/upd/sr")
    public ResultModel<MonthReport> updateBySr(@Valid @RequestBody UpdSrMReportDto dto) {
        MonthReport mr = monthlyReportService.updateBySr(dto);
        return success(mr);
    }

    /**
     * 企业填写月报意见
     * 角色：企业负责人
     *
     * @param dto 月报
     * @return 修改成功之后的月报对象
     */
    @PutMapping("/upd/er")
    public ResultModel<MonthReport> updateEr(@Valid @RequestBody UpdErMReportDto dto) {
        MonthReport mr = monthlyReportService.updateByEr(dto);
        return success(mr);
    }

    /**
     * 删除月报信息
     * 角色：学生
     *
     * @param stuId         学生id
     * @param monthReportId 月报id
     * @return 删除成功之后的月报对象
     */
    @DeleteMapping("/del//{stuId:\\d+}/{mrId:\\d+}")
    public ResultModel<MonthReport> delete(
            @PathVariable("stuId") Long stuId, @PathVariable("mrId") Long monthReportId) {
        MonthReport mr = monthlyReportService.deleteById(stuId, monthReportId);
        return success(mr);
    }

    /**
     * 查询月报信息
     * 角色：所有登录用户和月报属于的当前的学生
     * 条件：学生学号、提交时间、学校名称、企业name
     *
     * @param queryCondition 查询条件
     * @return 查询的月报信息列表
     */
    @PostMapping("/query")
    public ResultModel<List<MonthReport>> query(@Valid @RequestBody MonthlyReportQueryModel queryCondition) {
        List<MonthReport> list = monthlyReportService.queryByCondition(queryCondition);
        return success(list);
    }
}
