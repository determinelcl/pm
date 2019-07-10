package com.practice.management.bean.model;

import org.hibernate.validator.constraints.Range;

public class RoleQueryModel {
    private String roleName;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private Integer query;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private Integer save;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private Integer del;
    @Range(min = 0, max = 1, message = "权限设置1表示拥有权限，0则表示没有权限")
    private Integer upd;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getQuery() {
        return query;
    }

    public void setQuery(Integer query) {
        this.query = query;
    }

    public Integer getSave() {
        return save;
    }

    public void setSave(Integer save) {
        this.save = save;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getUpd() {
        return upd;
    }

    public void setUpd(Integer upd) {
        this.upd = upd;
    }
}
