package com.practice.management.bean.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdRoleDto {
    @NotNull(message = "用户id不能为空")
    private Long userId;
    @NotNull(message = "用户类型不能为空")
    @Range(min = 0, max = 3, message = "用户类型不存在")
    private int userType;

    @NotNull(message = "角色id不能为空")
    private Long roleId;
    @NotBlank(message = "角色名称不能为空")
    private String type;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private int query;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private int save;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private int del;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private int upd;
    @NotBlank(message = "角色英文标识不能为空")
    private String en;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getUpd() {
        return upd;
    }

    public void setUpd(int upd) {
        this.upd = upd;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
