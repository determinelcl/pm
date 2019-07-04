package com.practice.management.service;

import com.practice.management.bean.entity.EnterpriseProgramme;

public interface EnterpriseProgrammeService {
    /**
     * 根据id查询企业培训方案
     *
     * @param programmeId 企业培训方案id
     * @return 企业培训方案对象
     */
    EnterpriseProgramme findById(Long programmeId);
}
