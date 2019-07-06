package com.practice.management.controller;

import com.practice.management.bean.dto.AddRoleDto;
import com.practice.management.bean.dto.AssignRoleAuthorityDto;
import com.practice.management.bean.dto.UpdRoleDto;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.model.RoleQueryModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色：
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param dto 角色dto
     * @return 添加完成的角色对象
     */
    @PostMapping("/add")
    public ResultModel<Role> add(@RequestBody AddRoleDto dto) {
        Role role = roleService.add(dto);
        return success("添加成功", role);
    }


    /**
     * 修改角色权限
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param dto 角色dto
     * @return 修改完成的角色对象
     */
    @PutMapping("/update")
    public ResultModel<Role> Update(@RequestBody UpdRoleDto dto) {
        Role role = roleService.update(dto);
        return success("修改成功", role);
    }


    /**
     * 分配角色权限
     * 角色：超级管理员分配企业负责人和学校负责人的权限
     *      企业负责人分配企业老师的权限
     *      学校负责人分配学校老师的权限
     *
     * @param dto 角色dto
     * @return 分配完成的信息
     */
    @PutMapping("/assign/authority")
    public ResultModel<Role> assignAuthority(@RequestBody AssignRoleAuthorityDto dto) {
        Role role = roleService.assignAuthority(dto);
        return success("权限分配成功", role);
    }


    /**
     * 删除角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param userType 删除角色的用户类型
     * @param userId 删除角色的用户id
     * @param roleId 删除的角色id
     * @return 删除的角色对象
     */
    @DeleteMapping("/del/{type:\\d+}/{userId:\\d+}/{roleId:\\d+}")
    public ResultModel<Role> delete(@PathVariable("type") Integer userType,
            @PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) {
        Role role = roleService.delete(userType, userId, roleId);
        return success("删除成功", role);
    }


    /**
     * 查询角色角色
     * 角色：超级管理员、企业负责人、学校负责人
     *
     * @param queryModel 查询条件
     * @return 查询的角色列表
     */
    @GetMapping("/query")
    public ResultModel<List<Role>> query(@RequestBody RoleQueryModel queryModel) {
        List<Role> roleList = roleService.query(queryModel);
        return success("查询完成", roleList);
    }
}
