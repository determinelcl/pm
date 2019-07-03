package com.practice.management.controller;

import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.entity.Student;
import com.practice.management.bean.model.SchoolQueryModel;
import com.practice.management.controller.common.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师：CURD操作
 */
@RestController
@RequestMapping("/sr")
public class SchoolResponsibilityController extends BaseController {


    /**
     * 学校负责人添加学校
     * 角色：学校负责人
     *
     * @param school 学校负责人添加的学校
     * @return 添加是否成功的消息
     */
    @PostMapping("/sc/add")
    public ResultModel<String> addSchool(@RequestParam("srId") Integer srId, @RequestParam("school") School school) {
        return success("添加成功");
    }

    /**
     * 添加学生
     * 角色：学校老师
     *
     * @param student 学生信息实体对象
     * @return 添加是否成功
     */
    @PostMapping("/stu/add")
    public ResultModel<Account> addStudent(@RequestBody Student student) {
//        authService.register(student);

        return success("注册成功");
    }


    /**
     * 学校负责人添加学校老师
     * 角色：学校负责人
     *
     * @param sr 学校负责人
     * @return 添加是否成功的消息
     */
    @PostMapping("/teacher/add")
    public ResultModel<String> addTeacher(SchoolResponsibility sr) {
        return success("添加成功");
    }

    /**
     * 更新学校负责人个人信息/学校负责人还可以更新老师信息
     * 角色：学校负责人、学校老师
     *
     * @param sr 学校负责人
     * @return 更新结果
     */
    @PutMapping("/upd")
    public ResultModel<SchoolResponsibility> updateSR(SchoolResponsibility sr) {
        return success(new SchoolResponsibility());
    }


    /**
     * 根据指定的学校老师id删除学校负责人
     * 角色：学校负责人
     *
     * @param id 学校老师id
     * @return 删除结果
     */
    @DeleteMapping("/del/{id:\\d+}")
    public ResultModel<String> deleteSR(@PathVariable("id") int id) {
        return success("删除成功");
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
    public ResultModel<List<SchoolResponsibility>> query(SchoolQueryModel queryCondition) {

        return success(null);
    }

}
