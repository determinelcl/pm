package com.practice.management.controller;

import com.practice.management.bean.dto.ResultModel;
import com.practice.management.bean.entity.User;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册、登录
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回User对象否则返回null
     */
    @PostMapping("/login")
    public ResultModel<User> login(String username, String password) {
        return success(new User());
    }


    @PostMapping("/register")
    public ResultModel<String> register(User user) {

        return success("this is test");
    }


}
