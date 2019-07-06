package com.practice.management.bean.dto;

import java.util.List;

public class AssignRoleAuthorityDto {
    private Long userId;
    private int userType;

    private Long roleId;
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
