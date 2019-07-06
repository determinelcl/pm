package com.practice.management.service;

import com.practice.management.bean.dto.AddRoleDto;
import com.practice.management.bean.dto.AssignRoleAuthorityDto;
import com.practice.management.bean.dto.UpdRoleDto;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.RoleQueryModel;

import java.util.List;

public interface RoleService {
    /**
     * 根据角色id查询角色对象
     *
     * @param roleId 角色id
     * @return 如果存在返回角色对象，否则返回null
     */
    Role findById(Long roleId);

    /**
     * 添加角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param dto 角色dto
     * @return 添加完成的角色对象
     */
    Role add(AddRoleDto dto);

    /**
     * 修改角色权限
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param dto 角色dto
     * @return 修改完成的角色对象
     */
    Role update(UpdRoleDto dto);

    /**
     * 分配角色权限
     * 角色：超级管理员分配企业负责人和学校负责人的权限
     *      企业负责人分配企业老师的权限
     *      学校负责人分配学校老师的权限
     *
     * @param dto 角色dto
     * @return 分配完成的信息
     */
    Role assignAuthority(AssignRoleAuthorityDto dto);

    /**
     * 删除角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param userType 删除角色的用户类型
     * @param userId 删除角色的用户id
     * @param roleId 删除的角色id
     * @return 删除的角色对象
     */
    Role delete(int userType, Long userId, Long roleId);

    /**
     * 查询角色角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param queryCondition 查询条件
     * @return 查询的角色列表
     */
    List<Role> query(RoleQueryModel queryCondition);

    /**
     * 权限分配验证
     *
     * @param highRoleId 拥有高权限的角色id，负责分配权限的id
     * @param lowRoleId  拥有低权限的角色id，被分配权限的id
     */
    void authorityValidate(Long highRoleId, Long lowRoleId);
}
