package com.practice.management.service;

import com.practice.management.bean.entity.Major;

public interface MajorService {
    /**
     * 根据专业id查询专业对象
     *
     * @param majorId 专业id
     * @return 如果存在则返回专业对象。否则报告错误信息
     */
    Major findById(Long majorId);
}
