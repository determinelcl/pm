package com.practice.management.controller;

import com.practice.management.bean.entity.Enterprise;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.SchoolQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.EnterpriseService;
import com.practice.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学校：
 */
@RestController
@RequestMapping("/query")
public class SchoolEnterpriseController extends BaseController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 根据查询学校
     * 角色：admin
     *
     * @param queryCondition 查询条件对象
     * @return 查询的学校列表
     */
    @PostMapping("/school")
    public ResultModel<List<School>> queryBySchool(@RequestBody SchoolQueryModel queryCondition) {
        List<School> schoolList = schoolService.query(queryCondition);
        return success("查询完成", schoolList);
    }

    /**
     * 根据查询企业
     * 角色：admin
     *
     * @param queryCondition 查询条件对象
     * @return 查询的企业列表
     */
    @PostMapping("/enp")
    public ResultModel<List<Enterprise>> queryByEnterprise(@RequestBody EnterpriseQueryModel queryCondition) {
        List<Enterprise> enterpriseList = enterpriseService.query(queryCondition);
        return success("查询完成", enterpriseList);
    }
}
