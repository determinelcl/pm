package com.practice.management.controller;

import com.alibaba.fastjson.JSON;
import com.practice.management.bean.dto.AddEpDto;
import com.practice.management.bean.dto.UpdEpDto;
import com.practice.management.bean.entity.EnterpriseProgramme;
import com.practice.management.bean.model.EpQueryModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.EnterpriseProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * 企业培养方案：CURD
 * 角色：企业
 */
@RestController
@RequestMapping("/culture")
public class EnterpriseCultureController extends BaseController {

    @Autowired
    private EnterpriseProgrammeService programmeService;

    /**
     * 添加企业课程
     * 角色：企业负责人
     *
     * @param json 课程json串
     * @param file 用于描述课程的文件
     * @return 添加完成的课程对象
     */
    @PostMapping("/add")
    public ResultModel<EnterpriseProgramme> add(@RequestParam("data") String json, MultipartFile file) {
        if (file == null)
            throw new RuntimeException("企业课程描述文件不能为空");

        AddEpDto dto = JSON.parseObject(json, AddEpDto.class);
        dto.setFile(file);
        EnterpriseProgramme programme = programmeService.add(dto);
        return success("添加成功", programme);
    }

    /**
     * 修改企业课程
     * 角色：企业负责人
     *
     * @param json 课程json串
     * @param file 用于描述课程的文件
     * @return 修改完成的课程对象
     */
    @PutMapping("/upd")
    public ResultModel<EnterpriseProgramme> update(@RequestParam("data") String json, MultipartFile file) {
        UpdEpDto dto = JSON.parseObject(json, UpdEpDto.class);
        dto.setFile(file);
        EnterpriseProgramme programme = programmeService.update(dto);
        return success("修改成功", programme);
    }

    /**
     * 删除企业课程
     * 角色：企业负责人
     *
     * @param erId 企业负责人id
     * @param epId 课程id
     * @return 删除完成的课程对象
     */
    @DeleteMapping("/del/{erId:\\d+}/{epId:\\d+}")
    public ResultModel<EnterpriseProgramme> delete(@PathVariable("erId") Long erId, @PathVariable("epId") Long epId) {
        EnterpriseProgramme programme = programmeService.delete(erId, epId);
        return success("删除成功", programme);
    }


    /**
     * 查询企业课程
     * 角色：所有登录的角色
     *
     * @param queryCondition 查询条件
     * @return 查询的企业课程列表
     */
    @PostMapping("/query")
    public ResultModel<List<EnterpriseProgramme>> query(@Valid @RequestBody EpQueryModel queryCondition) {
        List<EnterpriseProgramme> programmeList = programmeService.query(queryCondition);
        return success("修改成功", programmeList);
    }
}
