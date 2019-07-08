package com.practice.management.service;


import com.practice.management.bean.entity.*;
import com.practice.management.bean.model.JwtUser;
import com.practice.management.constrant.SchoolAndEnpEnum;
import com.practice.management.constrant.UserAuth;
import com.practice.management.exception.IdentificationException;
import com.practice.management.mapper.*;
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

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] param = username.split(UserAuth.USERNAME_SEP);
        Long id = Long.parseLong(param[0]);
        String name = param[1];
        String type = param[2];

        Account account = null;

        if (type.equals(SchoolAndEnpEnum.STUDENT.name())) { // 查询学生
            School school = schoolMapper.findById(id);
            if (school == null)
                throw new IdentificationException("学生id：" + id + "不存在");

            account = accountMapper.findByAccount(id, name, 1);
        } else if (type.equals(SchoolAndEnpEnum.SCHOOL.name())) { // 查询学校
            School school = schoolMapper.findById(id);
            if (school == null)
                throw new IdentificationException("学校id：" + id + "不存在");

            account = accountMapper.findByAccount(id, name, 2);
        } else if (type.equals(SchoolAndEnpEnum.ENTERPRISE.name())) { // 查询企业
            Enterprise enterprise = enterpriseMapper.findById(id);
            if (enterprise == null)
                throw new IdentificationException("企业id：" + id + "不存在");

            account = accountMapper.findByAccount(id, name, 3);
        } else if (type.equals(SchoolAndEnpEnum.ADMIN.name())) {    // 查询管理员
            if (!id.equals(UserAuth.ADMIN_DEPT_ID))
                throw new RuntimeException("使用管理登录错误，操作违法，请谨慎处理！");
            account = accountMapper.findByAccount(id, name, 0);
        }

        if (account == null)
            throw new UsernameNotFoundException(String.format("用户：%s信息不存在", username));


        Long roleId = account.getRoleId();
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("用户角色id:" + roleId + "不存在");

        account.setRoles(Collections.singletonList(role));
        account.setAccount(username);
        return new JwtUser(account);
    }
}
