package com.practice.management.mapper;

import com.practice.management.bean.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into account(id, username, password) " +
            "values(#{id}, #{username}, #{password})")
    Account add(Account account);


}
