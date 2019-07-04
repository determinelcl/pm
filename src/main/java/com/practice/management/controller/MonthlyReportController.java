package com.practice.management.controller;

import com.practice.management.bean.entity.MonthReport;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MonthlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 月报：CURD
 * 角色：学生：CURD
 *      老师：审核
 *      企业：意见
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
    public ResultModel<MonthReport> add(@RequestBody MonthReport monthReport) {
        MonthReport mr = monthlyReportService.add(monthReport);
        return success(mr);
    }

    /**
     * 修改月报信息
     * 角色：学生
     *      企业负责人可以修改企业意见、
     *      学校负责人可以审核
     *
     * @param monthReport 月报
     * @return 修改成功之后的月报对象
     */
    @PutMapping("/upd")
    public ResultModel<MonthReport> update(@RequestBody MonthReport monthReport) {
        MonthReport mr = monthlyReportService.updateById(monthReport);
        return success(mr);
    }

    /**
     * 删除月报信息
     * 角色：学生
     *
     * @param mrId 月报id
     * @return 修改成功之后的月报对象
     */
    @PutMapping("/del/{id:\\d+}")
    public ResultModel<MonthReport> delete(@PathVariable("id") Long mrId) {
        MonthReport mr = monthlyReportService.deleteById(mrId);
        return success(mr);
    }

    /**
     * 查询月报信息
     * 角色：所有登录用户和学生
     * 条件：学生学号、提交时间、学校名称、企业name
     *
     * @param monthReport 查询条件
     * @return 查询的月报信息列表
     */
    @PutMapping("/upd")
    public ResultModel<List<MonthReport>> query(@RequestBody MonthReport monthReport) {
        List<MonthReport> list = monthlyReportService.query(monthReport);
        return success(list);
    }
}
