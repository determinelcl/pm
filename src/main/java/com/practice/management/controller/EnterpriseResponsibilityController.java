package com.practice.management.controller;

import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.EnterpriseResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 企业负责人+企业：
 * 个人信息的CURD
 */
@RestController
@RequestMapping("/er")
public class EnterpriseResponsibilityController extends BaseController {

    @Autowired
    private EnterpriseResponsibilityService erService;

    /**
     * 企业负责人更新企业信息
     * 角色：企业负责人
     *
     * @param er 负责人添加的企业
     * @return 添加是否成功的消息
     */
    @PostMapping("/enp/upd")
    public ResultModel<String> updEnterprise(@RequestBody EnterpriseResponsibility er) {
        erService.updEnterprise(er);
        return success("添加成功");
    }


    /**
     * 企业负责人添加企业老师
     * 角色：企业负责人
     *
     * @param er 企业负责人
     * @return 添加是否成功的消息
     */
    @PostMapping("/teacher/add")
    public ResultModel<String> addTeacher(EnterpriseResponsibility er) {
        erService.addTeacher(er);
        return success("添加成功");
    }

    /**
     * 更新企业负责人个人信息/企业负责人还可以更新企业老师信息
     * 角色：企业负责人、企业老师
     *
     * @param er 企业负责人
     * @return 更新结果
     */
    @PutMapping("/upd")
    public ResultModel<EnterpriseResponsibility> updateER(EnterpriseResponsibility er) {
        erService.updEr(er);
        return success(er);
    }

    /**
     * 企业负责人更新企业老师信息
     * 角色：企业负责人
     *
     * @param er 企业老师信息
     * @return 更新结果
     */
    @PutMapping("/upd")
    public ResultModel<EnterpriseResponsibility> updateERTeacher(EnterpriseResponsibility er) {
        erService.updErTeacher(er);
        return success(er);
    }


    /**
     * 根据指定的企业老师id删除企业老师
     * 角色：企业负责人
     *
     * @param id 企业老师id
     * @return 删除结果
     */
    @DeleteMapping("/del/{erId:\\d+}/{id:\\d+}")
    public ResultModel<String> deleteER(@PathVariable("erId") Long erId, @PathVariable("id") Long id) {
        erService.deleteById(erId, id);
        return success("删除成功");
    }

    /**
     * 根据给定的条件查询企业老师
     * 角   色：企业负责人
     * 查询条件：企业老师工号/name
     *
     * @param queryCondition 企业负责人实体的所有字段都可以作为查询条件
     * @return 查询到的企业负责人信息
     */
    @GetMapping("/query")
    public ResultModel<List<EnterpriseResponsibility>> query(EnpQueryModel queryCondition) {
        List<EnterpriseResponsibility> list = erService.queryByCondition(queryCondition);
        return success(list);
    }
}
