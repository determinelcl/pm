package com.practice.management.controller;

import com.practice.management.bean.dto.AddMajorDto;
import com.practice.management.bean.dto.UpdMajorDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.model.MajorQueryModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController extends BaseController {

    @Autowired
    private MajorService majorService;

    /**
     * 添加学校专业
     * 角色：学校负责人
     *
     * @param dto 专业
     * @return 添加完成的专业对象
     */
    @PostMapping("/add")
    public ResultModel<Major> add(@RequestBody AddMajorDto dto) {
        Major major = majorService.add(dto);
        return success("添加成功", major);
    }

    /**
     * 修改学校专业
     * 角色：学校负责人
     *
     * @param dto 专业
     * @return 修改完成的专业对象
     */
    @PostMapping("/upd")
    public ResultModel<Major> update(@RequestBody UpdMajorDto dto) {
        Major major = majorService.update(dto);
        return success("修改成功", major);
    }

    /**
     * 删除学校专业
     * 角色：学校负责人
     *
     * @param srId 学校负责人id
     * @param majorId 专业id
     * @return 删除完成的专业对象
     */
    @PostMapping("/del/{erId:\\d+}/{majorId:\\d+}}")
    public ResultModel<Major> delete(@PathVariable("erId") Long srId, @PathVariable("majorId") Long majorId) {
        Major major = majorService.delete(srId, majorId);
        return success("删除成功", major);
    }


    /**
     * 查询学校专业
     * 角色：所有登录的角色
     *
     * @param queryCondition 查询条件
     * @return 查询的学校专业列表
     */
    @PostMapping("/upd")
    public ResultModel<List<Major>> query(@RequestBody MajorQueryModel queryCondition) {
        List<Major> majorList = majorService.query(queryCondition);
        return success("修改成功", majorList);
    }
}
