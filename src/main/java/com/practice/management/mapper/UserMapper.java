package com.practice.management.mapper;

import com.practice.management.bean.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into account(id, username, password) " +
            "values(#{id}, #{username}, #{password})")
    Account add(Account account);

    /**
     * 根据指定的用户名查询用户
     *
     * @param username 用户
     * @return 查询到的用户对象
     */
    @Select("select * from user where username=#{username}")
    User getUserByName(@Param("username") String username);

}
