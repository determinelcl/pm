package com.practice.management.service.impl;

import com.practice.management.bean.entity.Role;
import com.practice.management.mapper.RoleMapper;
import com.practice.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(Long roleId) {
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("角色id:" + roleId + "不存在");

        return role;
    }
}
