package com.practice.management.bean.model;

/**
 * 登录认证对象模型
 */
public class AuthModel {
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    /**
     * 认证关联的id：学校id/企业id
     */
    private Long foreignId;

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

    public Long getForeignId() {
        return foreignId;
    }

    public void setForeignId(Long foreignId) {
        this.foreignId = foreignId;
    }
}
