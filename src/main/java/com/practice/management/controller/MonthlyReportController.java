package com.practice.management.controller;

import com.practice.management.bean.dto.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MonthlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResultModel<String> add() {
        monthlyReportService.add();
        return success("添加成功");
    }
}
