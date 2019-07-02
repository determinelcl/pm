package com.practice.management.bean.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final String email;
    private final int roleId;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;

    public JwtUser(Account user) {

        this.id = user.getId();
        this.username = user.getAccount();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.roleId = user.getRoleId();
        this.authorities = mapToGrantedAuthority(user.getRoles());
        this.lastPasswordResetDate = user.getLastPasswordResetDate();
    }

    private Collection<? extends GrantedAuthority> mapToGrantedAuthority(List<Role> roles) {
        if (roles == null) return null;

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getEn()))
                .collect(Collectors.toList());
    }


    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @JsonIgnore
    public String getEmail() {
        return email;
    }

    public int getRoleId() {
        return roleId;
    }
}
