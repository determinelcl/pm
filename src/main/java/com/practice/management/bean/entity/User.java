package com.practice.management.bean.entity;

import java.io.Serializable;

/**
 * 用户：可以表示学生、学校负责人和企业负责人
 */
public class User implements Serializable {
    private String account;
    private String password;
    private Integer type;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
