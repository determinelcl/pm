package com.practice.management.mapper;

import com.practice.management.bean.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where account=#{id}")
    Admin findById(@Param("id") Long id);

    @Select("select * from admin where account=#{account}")
    Admin findByAccount(@Param("account") String account);
}
