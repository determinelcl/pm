package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddRoleDto;
import com.practice.management.bean.dto.AssignRoleAuthorityDto;
import com.practice.management.bean.dto.UpdRoleDto;
import com.practice.management.bean.entity.Admin;
import com.practice.management.bean.entity.MenuRole;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.RoleQueryModel;
import com.practice.management.constrant.RoleType;
import com.practice.management.mapper.AdminMapper;
import com.practice.management.mapper.RoleMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private MenuRoleService menuRoleService;

    @Autowired
    private SchoolResponsibilityService srService;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Override
    public Role findById(Long roleId) {
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("角色id:" + roleId + "不存在");

        return role;
    }

    @Transactional
    @Override
    public Role add(AddRoleDto dto) {
        validateRoleAuthority(dto, validateUser(dto.getUserType(), dto.getUserId()));

        Long roleId = roleMapper.add(dto);
        return roleMapper.findById(roleId);
    }

    private void validateRoleAuthority(Role dto, Long highRoleId) {
        if (highRoleId == -1L)
            return;

        Role highRole = roleMapper.findById(highRoleId);
        if (!isValidRole(dto, highRole))
            throw new RuntimeException("用户权限添加不能超过自己的权限范围");
    }

    private Long validateUser(int userType, Long userId) {
        Long highRoleId;
        if (userType == RoleType.ROOT) {
            Admin admin = adminMapper.findById(userId);
            if (admin == null)
                throw new RuntimeException("误用管理员授权，操作违法，请谨慎处理！");
            highRoleId = admin.getRoleId();
        } else if (userType == RoleType.SCHOOL)
            highRoleId = srService.validateSrAuthority(userId).getRoleId();
        else if (userType == RoleType.ENTERPRISE)
            highRoleId = erService.validateErAuthority(userId).getRoleId();
        else
            throw new RuntimeException("用户类型不存在");

        return highRoleId;
    }

    @Transactional
    @Override
    public Role update(UpdRoleDto dto) {
        Role role = findById(dto.getRoleId());
        validateRoleAuthority(role, validateUser(dto.getUserType(), dto.getUserId()));

        roleMapper.update(dto);
        return roleMapper.findById(role.getId());
    }

    @Transactional
    @Override
    public Role assignAuthority(AssignRoleAuthorityDto dto) {
        Role role = findById(dto.getRoleId());
        Long highRoleId = validateUser(dto.getUserType(), dto.getUserId());
        validateRoleAuthority(role, highRoleId);


        List<MenuRole> highMenuRoleList = menuRoleService.findByRoleId(highRoleId);
        List<Long> highMenuIds = highMenuRoleList.stream().map(MenuRole::getMenuId).collect(Collectors.toList());
        validateMenuAuthority(highMenuIds, dto.getMenuList());

        menuRoleService.addBatch(role.getId(), dto.getMenuList());
        return role;
    }

    @Transactional
    @Override
    public Role delete(int userType, Long userId, Long roleId) {
        Role role = findById(roleId);
        validateRoleAuthority(role, validateUser(userType, userId));

        roleMapper.deleteById(roleId);
        return role;
    }

    @Override
    public List<Role> query(RoleQueryModel queryCondition) {
        return roleMapper.queryByCondition(queryCondition);
    }

    @Override
    public void authorityValidate(Long highRoleId, Long lowRoleId) {
        // 权限分配验证
        // 首先验证CURD的权限
        Role highRole = findById(highRoleId);
        Role lowRole = findById(lowRoleId);
        if (!isValidRole(lowRole, highRole))
            throw new RuntimeException("权限分配不能超出授权人的权限范围！");

        // 在验证分配功能的权限
        List<MenuRole> highMenuRoleList = menuRoleService.findByRoleId(highRoleId);
        List<MenuRole> lowMenuRoleList = menuRoleService.findByRoleId(lowRoleId);
        List<Long> highMenuIds = highMenuRoleList.stream().map(MenuRole::getMenuId).collect(Collectors.toList());
        List<Long> lowMenuIds = lowMenuRoleList.stream().map(MenuRole::getMenuId).collect(Collectors.toList());
        validateMenuAuthority(highMenuIds, lowMenuIds);
    }

    private void validateMenuAuthority(List<Long> highMenuIds, List<Long> lowMenuIds) {
        if (!highMenuIds.containsAll(lowMenuIds))
            throw new RuntimeException("权限分配不能超出授权人的权限范围！");
    }

    private boolean isValidRole(Role lowRole, Role highRole) {
        return lowRole.getSave() <= highRole.getSave() && lowRole.getDel() <= highRole.getDel() &&
                lowRole.getUpd() <= highRole.getUpd() && lowRole.getQuery() <= highRole.getQuery();
    }
}
