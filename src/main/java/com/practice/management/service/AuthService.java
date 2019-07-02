package com.practice.management.service;

import com.practice.management.bean.entity.Account;

public interface AuthService {
    void register(Account account);

    String login(String account, String password);

    String refresh(String oldToken);
}
