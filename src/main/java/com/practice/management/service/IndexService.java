package com.practice.management.service;

import com.practice.management.bean.entity.User;

/**
 * 登录、注册服务
 */
public interface IndexService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回User对象否则返回null
     */
    User login(String username, String password);

}
