package com.practice.management.service.impl;

import com.practice.management.bean.entity.*;
import com.practice.management.bean.model.AuthModel;
import com.practice.management.bean.model.JwtUser;
import com.practice.management.constrant.SchoolAndEnpEnum;
import com.practice.management.constrant.UserAuth;
import com.practice.management.mapper.AccountMapper;
import com.practice.management.service.AuthService;
import com.practice.management.service.EnterpriseService;
import com.practice.management.service.RoleService;
import com.practice.management.service.SchoolService;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public void register(Account account) {
        final String username = account.getAccount();
        int type = getTableType(account);
        // 验证关联的角色id是否存在
        roleService.findById(account.getRoleId());

        // 验证账号是否已经存在
        if (accountMapper.findByAccount(account.getForeignId(), username, type) != null)
            throw new RuntimeException(String.format("账号：%s已存在！", username));

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
    @Transactional
    public int getTableType(Account account) {
        int type = -1;
        if (account instanceof Student) {
            type = 1;
        } else if (account instanceof SchoolResponsibility) {
            validateSchool((SchoolResponsibility) account);
            type = 2;
        } else if (account instanceof EnterpriseResponsibility) {
            validateEnterprise((EnterpriseResponsibility) account);
            type = 3;
        }
        return type;
    }

    /**
     * 验证企业负责人和企业老师关联的企业
     *
     * @param erTemp 企业负责人和企业老师的对象
     */
    @Transactional
    public void validateEnterprise(EnterpriseResponsibility erTemp) {
        if (erTemp.getEnterpriseId() != null) {
            enterpriseService.findById(erTemp.getEnterpriseId());
            return;
        }

        erTemp.getEnterprise().setResponsibility_account(erTemp.getAccount());
        Enterprise enterprise = enterpriseService.add(erTemp.getEnterprise());
        erTemp.setEnterpriseId(enterprise.getId());
    }

    /**
     * 验证学校负责人和学校老师关联的企业
     *
     * @param srTemp 学校负责人和学校老师的对象
     */
    @Transactional
    public void validateSchool(SchoolResponsibility srTemp) {
        if (srTemp.getSchoolId() != null) {
            schoolService.findById(srTemp.getSchoolId());
            return;
        }

        srTemp.getSchool().setResponsibility_account(srTemp.getAccount());
        School school = schoolService.add(srTemp.getSchool());
        srTemp.setSchoolId(school.getId());
    }

    @Transactional
    @Override
    public String login(AuthModel authModel, SchoolAndEnpEnum type) {
        String realAccount = authModel.getForeignId() + UserAuth.USERNAME_SEP
                + authModel.getAccount() + UserAuth.USERNAME_SEP + type.name();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(realAccount, authModel.getPassword());

        final Authentication authenticate = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(realAccount);

        return jwtTokenUtil.generateToken(userDetails);
    }

    @Transactional
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
