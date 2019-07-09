package com.practice.management.controller;

import com.practice.management.bean.dto.AddSchoolTeacherDto;
import com.practice.management.bean.dto.UpdSchoolDto;
import com.practice.management.bean.dto.UpdSchoolTeacherDto;
import com.practice.management.bean.dto.UpdSrDto;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.SrQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.SchoolResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师：CURD操作
 */
@RestController
@RequestMapping("/sr")
public class SchoolResponsibilityController extends BaseController {

    @Autowired
    private SchoolResponsibilityService srService;

    /**
     * 学校负责人添加学校
     * 角色：学校负责人
     *
     * @param dto 学校负责人添加的学校
     * @return 添加是否成功的消息
     */
    @PostMapping("/sc/add")
    public ResultModel<School> updSchool(@RequestBody UpdSchoolDto dto) {
        School school = srService.updSchool(dto);
        return success(school);
    }


    /**
     * 学校负责人添加学校老师
     * 角色：学校负责人
     *
     * @param dto 学校老师dto
     * @return 添加是否成功的消息
     */
    @PostMapping("/teacher/add")
    public ResultModel<String> addTeacher(@RequestBody AddSchoolTeacherDto dto) {
        srService.addSchoolTeacher(dto);
        return success("添加成功");
    }

    /**
     * 更新学校负责人个人信息/学校负责人还可以更新老师信息
     * 角色：学校负责人、学校老师
     *
     * @param dto 学校负责人
     * @return 更新结果
     */
    @PutMapping("/upd")
    public ResultModel<SchoolResponsibility> updateSR(UpdSrDto dto) {
        SchoolResponsibility sr = srService.updateSr(dto);
        return success(sr);
    }

    /**
     * 学校负责人更新学校老师信息
     * 角色：学校负责人
     *
     * @param dto 学校老师dto
     * @return 更新的老师信息
     */
    @PutMapping("/upd/teacher")
    public ResultModel<SchoolResponsibility> updateSrTeacher(UpdSchoolTeacherDto dto) {
        SchoolResponsibility sr = srService.updSrTeacher(dto);
        return success(sr);
    }


    /**
     * 学校老师根据指定的学校老师id删除学校老师
     * 角色：学校负责人
     *
     * @param srId 学校负责人id
     * @param stId 学校老师id
     * @return 删除的学校老师信息
     */
    @DeleteMapping("/del/{srId:\\d+}/{stId:\\d+}")
    public ResultModel<SchoolResponsibility> deleteSR(
            @PathVariable("srId") Long srId, @PathVariable("stId") Long stId) {
        SchoolResponsibility sr = srService.deleteById(srId, stId);
        return success(sr);
    }

    /**
     * 根据给定的条件查询学校老师
     * 角   色：学校负责人
     * 查询条件：专业name、老师id/name
     *
     * @param queryCondition 学校负责人实体的所有字段都可以作为查询条件
     * @return 查询到的学校负责人信息
     */
    @GetMapping("/query")
    public ResultModel<List<SchoolResponsibility>> query(SrQueryModel queryCondition) {
        List<SchoolResponsibility> list = srService.queryByCondition(queryCondition);
        return success(list);
    }

    /**
     * 根据学校id和账号查询老师信息
     *
     * @param scId    学校id
     * @param account 学校负责人/老师账号
     * @return 学校负责人/老师个人信息
     */
    @GetMapping("/self/{scId:\\d+}/{account:\\S+}")
    public ResultModel<SchoolResponsibility> getSrSelf(@PathVariable("scId") Long scId,
                                                       @PathVariable("account") String account) {

        SchoolResponsibility sr = srService.findByScIdAndAccount(scId, account);
        return success(sr);
    }

}
