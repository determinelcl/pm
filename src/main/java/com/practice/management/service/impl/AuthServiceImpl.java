package com.practice.management.service.impl;

import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.EnterpriseResponsilbility;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.entity.Student;
import com.practice.management.bean.model.JwtUser;
import com.practice.management.mapper.AccountMapper;
import com.practice.management.service.AuthService;
import com.practice.management.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountMapper accountMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public void register(Account account) {
        final String username = account.getAccount();
        int type = getTableType(account);


        if (accountMapper.findByAccount(username, type) != null) return;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String password = account.getPassword();

        account.setPassword(encoder.encode(password));
        account.setLastPasswordResetDate(new Date());
        account.setAddTime(new Date());
        account.setRemarks("");

        accountMapper.add(account, type);
    }

    /**
     * 获取操作的用户的表的数据类型
     *
     * @param account 指定的账户对象
     * @return 学生：1，学校负责人：2，企业负责人：3
     */
    private int getTableType(Account account) {
        int type = -1;
        if (account instanceof Student) type = 1;
        else if (account instanceof SchoolResponsibility) type = 2;
        else if (account instanceof EnterpriseResponsilbility) type = 3;
        return type;
    }

    @Override
    public String login(String account, String password) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(account, password);

        final Authentication authenticate = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(account);

        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);

        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, jwtUser.getLastPasswordResetDate()))
            return jwtTokenUtil.refreshToken(token);

        return null;
    }
}
