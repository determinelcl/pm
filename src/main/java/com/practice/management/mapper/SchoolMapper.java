package com.practice.management.mapper;

import com.practice.management.bean.entity.School;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SchoolMapper {

    @Insert("insert into school(name, introduce, service_start_time, service_end_time, addtime, remarks) " +
            "values(#{name}, #{introduce}, #{serviceStartTime}, #{serviceEndTime}, #{addTime}, #{remarks})")
    void insert(School school);

    @Select("select * from school where name=#{name}")
    School findByName(@Param("name") String name);

    @Select("select * from school where id=#{id}")
    School findById(@Param("id") Long schoolId);
}
