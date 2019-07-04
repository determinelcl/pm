package com.practice.management.service;

import com.practice.management.bean.entity.Role;

public interface RoleService {
    /**
     * 根据角色id查询角色对象
     *
     * @param roleId 角色id
     * @return 如果存在返回角色对象，否则返回null
     */
    Role findById(Long roleId);
}
