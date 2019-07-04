package com.practice.management.mapper;

import com.practice.management.bean.entity.EnterpriseProgramme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnterpriseProgrammeMapper {

    @Select("select * from enterpriseprogramme where id=#{id}")
    EnterpriseProgramme findById(@Param("id") Long programmeId);
}
