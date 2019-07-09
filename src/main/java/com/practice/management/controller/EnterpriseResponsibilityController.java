package com.practice.management.controller;

import com.practice.management.bean.dto.AddEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdEnterpriseDto;
import com.practice.management.bean.dto.UpdEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdErDto;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;
import com.practice.management.bean.model.ResultModel;
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
     * @param dto 负责人添加的企业
     * @return 添加是否成功的消息
     */
    @PostMapping("/enp/upd")
    public ResultModel<String> updEnterprise(@RequestBody UpdEnterpriseDto dto) {
        erService.updEnterprise(dto);
        return success("添加成功");
    }


    /**
     * 企业负责人添加企业老师
     * 角色：企业负责人
     *
     * @param dto 企业负责人
     * @return 添加是否成功的消息
     */
    @PostMapping("/teacher/add")
    public ResultModel<String> addTeacher(@RequestBody AddEnterpriseTeacherDto dto) {
        erService.addTeacher(dto);
        return success("添加成功");
    }

    /**
     * 更新企业负责人个人信息
     * 角色：企业负责人、企业老师
     *
     * @param dto 企业负责人
     * @return 更新结果
     */
    @PutMapping("/upd")
    public ResultModel<EnterpriseResponsibility> updateER(@RequestBody UpdErDto dto) {
        EnterpriseResponsibility er = erService.updEr(dto);
        return success(er);
    }

    /**
     * 企业负责人更新企业老师信息
     * 角色：企业负责人
     *
     * @param dto 企业老师信息
     * @return 更新结果
     */
    @PutMapping("/upd/teacher")
    public ResultModel<EnterpriseResponsibility> updateERTeacher(@RequestBody UpdEnterpriseTeacherDto dto) {
        EnterpriseResponsibility er = erService.updErTeacher(dto);
        return success(er);
    }


    /**
     * 根据指定的企业老师id删除企业老师
     * 角色：企业负责人
     *
     * @param erId 企业负责人id
     * @param etId 企业老师id
     * @return 删除的企业老师信息
     */
    @DeleteMapping("/del/{erId:\\d+}/{etId:\\d+}")
    public ResultModel<EnterpriseResponsibility> deleteER(
            @PathVariable("erId") Long erId, @PathVariable("etId") Long etId) {

        EnterpriseResponsibility et = erService.deleteById(erId, etId);
        return success(et);
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
    public ResultModel<List<EnterpriseResponsibility>> query(@RequestBody EnpQueryModel queryCondition) {
        List<EnterpriseResponsibility> list = erService.queryByCondition(queryCondition);
        return success(list);
    }

    /**
     * 根据企业id和账号查询企业负责人/老师信息
     *
     * @param eId     企业id
     * @param account 企业负责人/老师账号
     * @return 企业负责人/老师个人信息
     */
    @GetMapping("/self/{eId:\\d+}/{account:\\S+}")
    public ResultModel<EnterpriseResponsibility> getSrSelf(@PathVariable("eId") Long eId,
                                                           @PathVariable("account") String account) {

        EnterpriseResponsibility er = erService.findByEcIdAndAccount(eId, account);
        return success(er);
    }
}
