package com.practice.management.bean.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class MenuQueryModel {
    @NotNull(message = "用户id不能为空")
    private Long id;
    @NotNull(message = "用户类型不能为空")
    @Range(min = 0, max = 3, message = "用户类型不存在")
    private int type;
    private String menuName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
