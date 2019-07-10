package com.practice.management.service;

import com.practice.management.bean.entity.Account;
import com.practice.management.bean.model.AuthModel;
import com.practice.management.constant.SchoolAndEnpEnum;

public interface AuthService {
    void register(Account account);

    String login(AuthModel authModel, SchoolAndEnpEnum password);

    String refresh(String oldToken);
}
