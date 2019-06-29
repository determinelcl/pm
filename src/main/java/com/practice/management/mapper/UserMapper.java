package com.practice.management.mapper;

import com.practice.management.bean.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(id, username, password) " +
            "values(#{id}, #{username}, #{password})")
    User add(User user);


}
