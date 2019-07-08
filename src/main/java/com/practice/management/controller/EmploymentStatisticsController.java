package com.practice.management.controller;

import com.practice.management.bean.dto.AddEmploymentDto;
import com.practice.management.bean.dto.UpdEmploymentDto;
import com.practice.management.bean.entity.Employment;
import com.practice.management.bean.model.EmploymentQueryModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.EmploymentStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 就业统计：CURD、文件上传
 * 角色：教师
 */
@RestController
@RequestMapping("/es")
public class EmploymentStatisticsController extends BaseController {

    @Autowired
    private EmploymentStatisticService statisticService;

    /**
     * 添加就业统计
     * 角色：学生
     *
     * @param dto 就业统计dto
     * @return 添加成功的就业统计
     */
    @PostMapping("/add")
    public ResultModel<Employment> add(@RequestBody AddEmploymentDto dto) {
        Employment employment = statisticService.add(dto);
        return success("添加成功", employment);
    }

    /**
     * 更新就业统计
     * 角色：学生
     *
     * @param dto 就业统计dto
     * @return 更新成功的就业统计
     */
    @PostMapping("/upd")
    public ResultModel<Employment> upd(@RequestBody UpdEmploymentDto dto) {
        Employment employment = statisticService.update(dto);
        return success("修改成功", employment);
    }

    /**
     * 查询就业统计
     * 角色：学校/企业/学生
     *
     * @param queryCondition 查询条件
     * @return 查询的就业统计的结果列表
     */
    @PostMapping("/query")
    public ResultModel<List<Employment>> query(@RequestBody EmploymentQueryModel queryCondition) {
        List<Employment> employmentList = statisticService.query(queryCondition);
        return success("查询成功", employmentList);
    }
}
