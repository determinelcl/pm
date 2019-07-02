package com.practice.management.service;


import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.JwtUser;
import com.practice.management.mapper.AccountMapper;
import com.practice.management.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.findByAccount(username, 1);
        if (account == null) {
            account = accountMapper.findByAccount(username, 2);
            if (account == null) {
                account = accountMapper.findByAccount(username, 3);
                if (account == null)
                    throw new UsernameNotFoundException(String.format("未查询到用户：%s信息", username));
            }
        }

        int roleId = account.getRoleId();
        Role role = roleMapper.findById(roleId);
        account.setRoles(Collections.singletonList(role));
        return new JwtUser(account);
    }
}
