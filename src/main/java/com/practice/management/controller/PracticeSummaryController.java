package com.practice.management.controller;

import com.alibaba.fastjson.JSON;
import com.practice.management.bean.dto.AddTrainSummaryDto;
import com.practice.management.bean.dto.UpdStuTrainSummaryDto;
import com.practice.management.bean.entity.TrainSummary;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.TrainSummaryQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.PracticeSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 实习总结：上传文件
 * 角色：1、学生：CURD
 * 2、老师：查看
 */
@RestController
@RequestMapping("/ps")
public class PracticeSummaryController extends BaseController {

    @Autowired
    private PracticeSummaryService summaryService;

    /**
     * 添加实训总结
     * 角色：学生
     *
     * @param data 实训总结对象
     * @param trainReport 实训报告文件
     * @param trainDesign 实训设计文件
     * @return 添加的结果
     */
    @PostMapping("/add")
    public ResultModel<TrainSummary> add(@RequestParam("data") String data, MultipartFile trainReport,
                                         MultipartFile trainDesign) {
        if (trainReport == null || trainDesign == null)
            throw new RuntimeException("上传文件不能为空");

        AddTrainSummaryDto summary = JSON.parseObject(data, AddTrainSummaryDto.class);

        summary.setTrainReport(trainReport);
        summary.setTrainDesign(trainDesign);
        TrainSummary rs = summaryService.add(summary);
        return success(rs);
    }

    /**
     * 修改实训总结信息
     * 角色：学生
     *
     * @param data 实训总结
     * @param trainReport 实训报告文件
     * @param trainDesign 实训设计文件
     * @return 修改成功之后的实训总结对象
     */
    @PutMapping("/upd/stu")
    public ResultModel<TrainSummary> updateByStu(@RequestParam("data") String data, MultipartFile trainReport,
                                                 MultipartFile trainDesign) {
        UpdStuTrainSummaryDto dto = JSON.parseObject(data, UpdStuTrainSummaryDto.class);

        dto.setTrainReport(trainReport);
        dto.setTrainDesign(trainDesign);
        TrainSummary mr = summaryService.updateByStu(dto);
        return success(mr);
    }

    /**
     * 删除实训总结信息
     * 角色：学生
     *
     * @param stuId     学生id
     * @param summaryId 实训总结id
     * @return 删除成功之后的实训总结对象
     */
    @DeleteMapping("/del/{stuId:\\d+}/{summaryId:\\d+}")
    public ResultModel<TrainSummary> delete(
            @PathVariable("stuId") Long stuId, @PathVariable("summaryId") Long summaryId) {
        TrainSummary mr = summaryService.deleteById(stuId, summaryId);
        return success(mr);
    }

    /**
     * 查询实训总结信息
     * 角色：学校负责人/老师和实训总结属于的当前的学生
     * 条件：学生学号、学校名称
     *
     * @param queryCondition 查询条件
     * @return 查询的实训总结信息列表
     */
    @PostMapping("/query")
    public ResultModel<List<TrainSummary>> query(@RequestBody TrainSummaryQueryModel queryCondition) {
        List<TrainSummary> list = summaryService.queryByCondition(queryCondition);
        return success(list);
    }

}
