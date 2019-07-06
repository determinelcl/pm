package com.practice.management.service.impl;

import com.practice.management.bean.entity.MenuRole;
import com.practice.management.mapper.MenuRoleMapper;
import com.practice.management.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<MenuRole> findByRoleId(Long roleId) {
        return menuRoleMapper.findByRoleId(roleId);
    }

    @Override
    public void addBatch(Long roleId, List<Long> menuList) {
        List<MenuRole> menuRoleList = new ArrayList<>();
        for (Long menuId: menuList) {
            MenuRole menuRole = new MenuRole();
            menuRole.setMenuId(menuId);
            menuRole.setRoleId(roleId);
            menuRoleList.add(menuRole);
        }

        menuRoleMapper.insertBatch(menuRoleList);
    }
}
