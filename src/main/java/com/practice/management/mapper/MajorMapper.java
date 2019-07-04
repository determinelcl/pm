package com.practice.management.mapper;

import com.practice.management.bean.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MajorMapper {

    @Select("select * from major where id=#{id}")
    Major findById(@Param("id") Long majorId);
}
