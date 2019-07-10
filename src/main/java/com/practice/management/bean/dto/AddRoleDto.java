package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Role;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class AddRoleDto extends Role {
    @NotNull(message = "用户id不能为空")
    private Long userId;
    @NotNull(message = "用户类型不能为空")
    @Range(min = 0, max = 3, message = "用户类型不存在")
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
