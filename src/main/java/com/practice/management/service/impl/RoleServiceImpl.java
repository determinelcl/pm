package com.practice.management.service.impl;

import com.practice.management.bean.entity.MenuRole;
import com.practice.management.bean.entity.Role;
import com.practice.management.mapper.RoleMapper;
import com.practice.management.service.MenuRoleService;
import com.practice.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuRoleService menuRoleService;

    @Override
    public Role findById(Long roleId) {
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("角色id:" + roleId + "不存在");

        return role;
    }

    @Override
    public void authorityValidate(Long highRoleId, Long lowRoleId) {
        // 权限分配验证
        // 首先验证CURD的权限
        Role srRole = findById(highRoleId);
        Role stuRole = findById(lowRoleId);
        if (!isValidRole(stuRole, srRole))
            throw new RuntimeException("权限分配不能超出授权人的权限！");

        // 在验证分配功能的权限
        List<MenuRole> srMenuRoleList = menuRoleService.findByRoleId(highRoleId);
        List<MenuRole> stuMenuRoleList = menuRoleService.findByRoleId(lowRoleId);
        List<Long> srMenuIds = srMenuRoleList.stream().map(MenuRole::getMenuId).collect(Collectors.toList());
        List<Long> stuMenuIds = stuMenuRoleList.stream().map(MenuRole::getMenuId).collect(Collectors.toList());
        if (!srMenuIds.containsAll(stuMenuIds))
            throw new RuntimeException("权限分配不能超出授权人的权限！");
    }

    private boolean isValidRole(Role stuRole, Role srRole) {
        return stuRole.getSave() <= srRole.getSave() && stuRole.getDel() <= srRole.getDel() &&
                stuRole.getUpd() <= srRole.getUpd() && stuRole.getQuery() <= srRole.getQuery();
    }
}
