package com.practice.management.bean.dto;

public class UpdRoleDto {
    private Long userId;
    private int userType;

    private Long roleId;
    private int query;
    private int save;
    private int del;
    private int upd;

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
}
