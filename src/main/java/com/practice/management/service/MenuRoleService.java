package com.practice.management.service;

import com.practice.management.bean.entity.MenuRole;

import java.util.List;

public interface MenuRoleService {
    /**
     * 根据角色id查询关联的菜单
     *
     * @param roleId 角色id
     * @return 角色对应的菜单列表
     */
    List<MenuRole> findByRoleId(Long roleId);

    void addBatch(Long roleId, List<Long> menuList);
}
