package com.practice.management.bean.model;

public class RoleQueryModel {
    private String roleName;
    private Integer query;
    private Integer save;
    private Integer del;
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
