package com.practice.management.bean.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AssignRoleAuthorityDto {
    @NotNull(message = "用户id不能为空")
    private Long userId;
    @NotNull(message = "用户类型不能为空")
    @Range(min = 0, max = 3, message = "用户类型不存在")
    private int userType;

    @NotNull(message = "角色id不能为空")
    private Long roleId;
    @NotNull(message = "分配的菜单列表不能为空")
    @NotEmpty(message = "分配的菜单列表不能为空")
    private List<Long> menuList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Long> menuList) {
        this.menuList = menuList;
    }
}
