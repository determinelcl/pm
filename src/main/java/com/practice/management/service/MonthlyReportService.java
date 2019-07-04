package com.practice.management.service;

import com.practice.management.bean.dto.UpdErMReportDto;
import com.practice.management.bean.dto.UpdSrMReportDto;
import com.practice.management.bean.dto.UpdStuMReportDto;
import com.practice.management.bean.entity.MonthReport;
import com.practice.management.bean.model.MonthlyReportQueryModel;

import java.util.List;

/**
 * 月报
 */
public interface MonthlyReportService {

    /**
     * 添加月报信息
     * 角色：学生
     *
     * @param monthReport 月报
     * @return 添加成功之后的月报对象
     */
    MonthReport add(MonthReport monthReport);

    /**
     * 根据月报id查询月报
     *
     * @param monthReportId 月报id
     * @return 月报信息对象
     */
    MonthReport findById(Long monthReportId);

    /**
     * 修改月报信息
     * 角色：学生
     *
     * @param dto 月报
     * @return 修改成功之后的月报对象
     */
    MonthReport updateByStu(UpdStuMReportDto dto);

    /**
     * 学校修审核月报
     * 角色：学校负责人
     *
     * @param dto 月报
     * @return 审核的月报对象
     */
    MonthReport updateBySr(UpdSrMReportDto dto);

    /**
     * 企业填写月报意见
     * 角色：企业负责人
     *
     * @param dto 月报
     * @return 修改成功之后的月报对象
     */
    MonthReport updateByEr(UpdErMReportDto dto);

    /**
     * 删除月报信息
     * 角色：学生
     *
     * @param stuId         学生id
     * @param monthReportId 月报id
     * @return 删除成功之后的月报对象
     */
    MonthReport deleteById(Long stuId, Long monthReportId);

    /**
     * 查询月报信息
     * 角色：所有登录用户和学生
     * 条件：学生学号、提交时间、学校名称、企业name
     *
     * @param queryCondition 查询条件
     * @return 查询的月报信息列表
     */
    List<MonthReport> queryByCondition(MonthlyReportQueryModel queryCondition);
}
