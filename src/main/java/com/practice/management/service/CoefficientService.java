package com.practice.management.service;

import com.practice.management.bean.entity.Coefficient;

public interface CoefficientService {

    /**
     * 根据id查询实习成绩阶段系数
     *
     * @param cId 实训成绩阶段系数id
     * @return 实习成绩阶段系数对象
     */
    Coefficient findById(Long cId);

    /**
     * 根据指定企业负责人/老师id添加实习成绩阶段系数
     *
     * @param coefficient 实习成绩阶段系数
     * @param erId 企业负责人/老师id
     */
    Coefficient addByErId(Coefficient coefficient, Long erId);
}
