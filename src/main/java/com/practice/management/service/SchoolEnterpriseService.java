package com.practice.management.service;

import com.practice.management.bean.entity.SchoolEnterprise;

public interface SchoolEnterpriseService {
    SchoolEnterprise findByScIdAndEnpId(Long scId, Long enpId);
}
