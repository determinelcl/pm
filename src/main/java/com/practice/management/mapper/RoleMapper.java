package com.practice.management.mapper;

import com.practice.management.bean.entity.Role;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RoleMapper {

    @Insert("add into role(type, queryByCondition, save, del, upd, en) " +
            "values(#{type}, #{queryByCondition}, #{save}, #{del}, #{upd}, #{en})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long add(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(@Param("id") Long id);
}
