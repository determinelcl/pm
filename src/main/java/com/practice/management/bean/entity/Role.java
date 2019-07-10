package com.practice.management.bean.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Role {
    private Long id;
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

    // 用于关联角色对应的菜单，非角色属性
    private List<Menu> menuList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<String> getAuthorities() {
        List<String> list = new ArrayList<>();
        if (query == 1) list.add(RequestMethod.GET.name());
        if (save == 1) list.add(RequestMethod.POST.name());
        if (del == 1) list.add(RequestMethod.DELETE.name());
        if (upd == 1) list.add(RequestMethod.PUT.name());

        return list;
    }

}
