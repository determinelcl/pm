package com.practice.management.service.impl;

import com.practice.management.bean.dto.UpdErMReportDto;
import com.practice.management.bean.dto.UpdSrMReportDto;
import com.practice.management.bean.dto.UpdStuMReportDto;
import com.practice.management.bean.entity.*;
import com.practice.management.bean.model.MonthlyReportQueryModel;
import com.practice.management.mapper.AdminMapper;
import com.practice.management.mapper.MonthlyReportMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MonthlyReportServiceImpl implements MonthlyReportService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private MonthlyReportMapper monthlyReportMapper;

    @Autowired
    private SchoolResponsibilityService srService;

    @Autowired
    private EnterpriseResponsibilityService erSerVice;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public MonthReport add(MonthReport monthReport) {
        Student student = studentService.findById(monthReport.getStudentId());
        Major major = majorService.findById(student.getMajorId());
        monthReport.setSchoolId(major.getSchoolId());

        if (!monthReport.getEnterpriseId().equals(student.getEnterpriseId()))
            throw new RuntimeException("提交的月报关联的企业不属于学生实习的企业");

        Date submitTime = new Date();
        monthReport.setSubmitTime(submitTime);
        monthReport.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        monthReport.setStudentId(student.getId());
        monthlyReportMapper.insert(monthReport);
        return monthReport;
    }

    @Override
    public MonthReport findById(Long monthReportId) {
        MonthReport monthReport = monthlyReportMapper.findById(monthReportId);
        if (monthReport == null)
            throw new RuntimeException("月报id:" + monthReportId + "不存在！");
        return monthReport;
    }

    @Override
    public MonthReport updateByStu(UpdStuMReportDto dto) {
        Long stuId = dto.getStuId();
        Long monthReportId = dto.getMonthReportId();
        validateMReportAuthority(stuId, monthReportId);

        monthlyReportMapper.updateByStu(dto);
        return findById(dto.getMonthReportId());
    }

    /**
     * 验证学生操作月报的权限
     *
     * @param stuId         学生id
     * @param monthReportId 月报id
     * @return 月报信息对象
     */
    private MonthReport validateMReportAuthority(Long stuId, Long monthReportId) {
        MonthReport monthReport = findById(monthReportId);
        if (!monthReport.getStudentId().equals(stuId))
            throw new RuntimeException("学生没有月报:" + monthReport.getId() + "的权限");
        return monthReport;
    }

    @Override
    public MonthReport updateBySr(UpdSrMReportDto dto) {
        SchoolResponsibility sr = srService.findById(dto.getSrId());
        MonthReport monthReport = findById(dto.getMonthReportId());
        if (!sr.getSchoolId().equals(monthReport.getSchoolId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "没有权限审核月报:" + monthReport.getId());

        monthlyReportMapper.updateBySr(dto);
        return findById(dto.getMonthReportId());
    }

    @Override
    public MonthReport updateByEr(UpdErMReportDto dto) {
        EnterpriseResponsibility er = erSerVice.findById(dto.getErId());
        MonthReport monthReport = findById(dto.getMonthReportId());
        if (!er.getEnterpriseId().equals(monthReport.getEnterpriseId()))
            throw new RuntimeException("企业负责人:" + er.getName() + "对月报:" + monthReport.getId() + "没有操作权限");

        monthlyReportMapper.updateByEr(dto);
        return findById(dto.getMonthReportId());
    }

    @Override
    public MonthReport deleteById(Long stuId, Long monthReportId) {
        MonthReport monthReport = validateMReportAuthority(stuId, monthReportId);

        monthlyReportMapper.deleteById(monthReportId);
        return monthReport;
    }


    @Override
    public List<MonthReport> queryByCondition(MonthlyReportQueryModel queryCondition) {
        if (queryCondition.getType() == 0) {
            Admin admin = adminMapper.findById(queryCondition.getId());
            if (admin == null)
                throw new RuntimeException("使用管理员进行查询，操作违法，请谨慎处理！");
        }

        return monthlyReportMapper.queryByCondition(queryCondition);
    }
}
