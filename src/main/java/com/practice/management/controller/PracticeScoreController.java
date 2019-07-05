package com.practice.management.controller;

import com.practice.management.bean.dto.AddTsDto;
import com.practice.management.bean.dto.UpdTsDto;
import com.practice.management.bean.entity.TrainScore;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.TsQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.PracticeScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 实习成绩：
 * 角色：企业
 * 录入阶段系数
 * 录入分数
 */
@RestController
@RequestMapping("/score")
public class PracticeScoreController extends BaseController {

    @Autowired
    private PracticeScoreService scoreService;

    /**
     * 添加学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param dto 实训成绩dto
     * @return 添加完成的实训成绩对象
     */
    @PostMapping("/add")
    public ResultModel<TrainScore> add(@RequestBody AddTsDto dto) {
        TrainScore score = scoreService.add(dto);
        return success("添加成功", score);
    }

    /**
     * 修改学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param dto 实训成绩dto
     * @return 修改完成的实训成绩对象
     */
    @PutMapping("/upd")
    public ResultModel<TrainScore> update(@RequestBody UpdTsDto dto) {
        TrainScore score = scoreService.update(dto);
        return success("添加成功", score);
    }

    /**
     * 删除学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param erId 企业负责人/老师id
     * @param tsId 实训成绩id
     * @return 添加完成的实训成绩对象
     */
    @DeleteMapping("/del/{erId:\\d+}/{tsId:\\d+}")
    public ResultModel<TrainScore> delete(
            @PathVariable("erId") Long erId, @PathVariable("tsId") Long tsId) {
        TrainScore score = scoreService.deleteById(erId, tsId);
        return success("添加成功", score);
    }


    /**
     * 查询学生的实训成绩
     * 角色：企业负责人/老师
     *
     * @param queryCondition 查询条件的模型对象
     * @return 符合条件的实训成绩对象
     */
    @GetMapping("/query")
    public ResultModel<TrainScore> query(@RequestBody TsQueryModel queryCondition) {
        TrainScore score = scoreService.query(queryCondition);
        return success("添加成功", score);
    }

}
