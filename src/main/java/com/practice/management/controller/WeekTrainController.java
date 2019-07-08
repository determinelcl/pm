package com.practice.management.controller;

import com.practice.management.bean.dto.AddWtDto;
import com.practice.management.bean.dto.UpdWtDto;
import com.practice.management.bean.entity.WeekTrain;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.WtQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.WeekTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/week")
public class WeekTrainController extends BaseController {

    @Autowired
    private WeekTrainService wtService;

    /**
     * 添加每周的实训情况
     * 角色：企业负责人
     *
     * @param dto 每周实训dto
     * @return 添加成功的每周实训对象
     */
    @PostMapping("/add")
    public ResultModel<WeekTrain> add(@RequestBody AddWtDto dto) {
        WeekTrain weekTrain = wtService.add(dto);
        return success("添加成功", weekTrain);
    }

    /**
     * 修改每周的实训情况
     * 角色：企业负责人
     *
     * @param dto 每周实训dto
     * @return 修改完成的每周实训对象
     */
    @PutMapping("/upd")
    public ResultModel<WeekTrain> upd(@RequestBody UpdWtDto dto) {
        WeekTrain weekTrain = wtService.update(dto);
        return success("修改成功", weekTrain);
    }

    /**
     * 根据id删除每周的实训情况
     * 角色：企业负责人
     *
     * @param erId 企业负责人id
     * @param wtId 每周实训对象id
     * @return 删除成功的每周实训对象
     */
    @DeleteMapping("/del/{erId:\\d+}/{wtId:\\d+}")
    public ResultModel<WeekTrain> delete(
            @PathVariable("erId") Long erId, @PathVariable("wtId") Long wtId) {
        WeekTrain weekTrain = wtService.delete(erId, wtId);
        return success("删除完成", weekTrain);
    }

    /**
     * 查询每周的实训情况
     * 角色：企业负责人/老师、学校负责人/老师、学生
     *
     * @param queryCondition 查询条件
     * @return 查询到的每周实训对象列表
     */
    @PostMapping("/add")
    public ResultModel<List<WeekTrain>> add(@RequestBody WtQueryModel queryCondition) {
        List<WeekTrain> weekTrainList = wtService.query(queryCondition);
        return success("查询完成", null);
    }
}
