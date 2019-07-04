package com.practice.management.service;

import com.practice.management.bean.entity.MonthReport;

import java.util.List;

/**
 * 月报
 */
public interface MonthlyReportService {

    /**
     * 添加月报
     * @param monthReport
     * @return
     */
    MonthReport add(MonthReport monthReport);

    MonthReport updateById(MonthReport monthReport);

    MonthReport deleteById(Long mrId);

    List<MonthReport> query(MonthReport monthReport);
}
