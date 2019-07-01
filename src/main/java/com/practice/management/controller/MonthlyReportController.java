package com.practice.management.controller;

import com.practice.management.bean.dto.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MonthlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monthly")
public class MonthlyReportController extends BaseController {

    @Autowired
    private MonthlyReportService monthlyReportService;

    public ResultModel<String> add() {
        monthlyReportService.add();
        return success("添加成功");
    }
}
