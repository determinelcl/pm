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

    /**
     * 权限分配验证
     *
     * @param highRoleId 拥有高权限的角色id，负责分配权限的id
     * @param lowRoleId  拥有低权限的角色id，被分配权限的id
     */
    void authorityValidate(Long highRoleId, Long lowRoleId);
}
