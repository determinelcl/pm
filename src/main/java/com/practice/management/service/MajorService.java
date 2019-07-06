package com.practice.management.service;

import com.practice.management.bean.dto.AddMajorDto;
import com.practice.management.bean.dto.UpdMajorDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.model.MajorQueryModel;

import java.util.List;

public interface MajorService {
    /**
     * 根据专业id查询专业对象
     *
     * @param majorId 专业id
     * @return 如果存在则返回专业对象。否则报告错误信息
     */
    Major findById(Long majorId);

    /**
     * 添加学校专业
     * 角色：学校负责人
     *
     * @param dto 专业
     * @return 添加完成的专业对象
     */
    Major add(AddMajorDto dto);

    /**
     * 修改学校专业
     * 角色：学校负责人
     *
     * @param dto 专业
     * @return 修改完成的专业对象
     */
    Major update(UpdMajorDto dto);

    /**
     * 删除学校专业
     * 角色：学校负责人
     *
     * @param srId 学校负责人id
     * @param majorId 专业id
     * @return 删除完成的专业对象
     */
    Major delete(Long srId, Long majorId);

    /**
     * 查询学校专业
     * 角色：所有登录的角色
     *
     * @param queryCondition 查询条件
     * @return 查询的学校专业列表
     */
    List<Major> query(MajorQueryModel queryCondition);
}
