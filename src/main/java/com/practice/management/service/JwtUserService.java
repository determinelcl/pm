package com.practice.management.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.practice.management.config.SpringContextHolder;
import com.practice.management.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

/**
 * 用户认证通过Provider来做，所以Provider需要拿到系统已经保存的认证信息，
 * 获取用户信息的接口spring-security抽象成UserDetailService
 * <p>
 * 用于获取用户认证信息
 */
public class JwtUserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    public JwtUserService() {
        // 默认使用 bcrypt， strength=10
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 根据指定的用户名获取用户的认证信息
     *
     * @param username 用户名
     * @return 用户的认证信息
     */
    public UserDetails getUserLoginInfo(String username) {
        String salt = "123456ef";

        // @todo 从数据库或者缓存中取出jwt token生成时用的salt
        // salt = redisTemplate.opsForValue().get("token:"+username);
        UserDetails user = loadUserByUsername(username);
        // 将salt放到password字段返回
        return User.builder().username(user.getUsername()).password(salt).authorities(user.getAuthorities()).build();
    }

    /**
     * 保存用户认证信息
     *
     * @param user 指定保存用户
     * @return 生成之后的token
     */
    public String saveUserLoginInfo(UserDetails user) {
        String salt = "123456ef";
        // BCrypt.gensalt()，正式开发时可以调用该方法实时生成加密的salt
        String gensalt = BCrypt.gensalt();

        // @todo 将salt保存到数据库或者缓存中
        // redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
        Algorithm algorithm = Algorithm.HMAC256(salt);
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);  //设置1小时后过期

        return JWT.create().withSubject(user.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        com.practice.management.bean.entity.User user = userMapper.getUserByName(username);

        if (user == null)
            throw new RuntimeException("用户名：" + username + "不存在！");

        return User.builder().username(user.getAccount())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles("USER").build();
    }

    public void createUser(String username, String password) {
        String encryptPwd = passwordEncoder.encode(password);
        /**
         * @todo 保存用户名和加密后密码到数据库
         */

    }

    public void deleteUserLoginInfo(String username) {
        /**
         * @todo 清除数据库或者缓存中登录salt
         */
    }
}
