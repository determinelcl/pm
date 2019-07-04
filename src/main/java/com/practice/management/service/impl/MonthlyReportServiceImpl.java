package com.practice.management.service.impl;

import com.practice.management.bean.entity.MonthReport;
import com.practice.management.service.MonthlyReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyReportServiceImpl implements MonthlyReportService {

    @Override
    public MonthReport add(MonthReport monthReport) {
        return monthReport;
    }

    @Override
    public MonthReport updateById(MonthReport monthReport) {
        return null;
    }

    @Override
    public MonthReport deleteById(Long mrId) {
        return null;
    }

    @Override
    public List<MonthReport> query(MonthReport monthReport) {
        return null;
    }
}
