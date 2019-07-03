package com.practice.management.service;

import com.practice.management.bean.entity.Enterprise;

public interface EnterpriseService {

    /**
     * 添加企业信息
     *
     * @param enterprise 企业信息对象
     * @return 添加完成的企业
     */
    Enterprise add(Enterprise enterprise);

    Enterprise findById(Long enpId);
}
