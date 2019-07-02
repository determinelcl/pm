package com.practice.management.mapper;

import com.practice.management.bean.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Insert("add into role(type, query, save, del, upd, en) " +
            "values(#{type}, #{query}, #{save}, #{del}, #{upd}, #{en})")
    void add(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(@Param("id") int id);
}
