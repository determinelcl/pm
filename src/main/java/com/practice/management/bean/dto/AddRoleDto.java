package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Role;

public class AddRoleDto extends Role {
    private Long userId;
    private int userType;

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
}
