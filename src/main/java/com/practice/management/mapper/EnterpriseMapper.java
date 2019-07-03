package com.practice.management.mapper;

import com.practice.management.bean.entity.Enterprise;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into enterprise(name, introduce, service_start_time, service_end_time, addtime, remarks)" +
            "values(#{name}, #{introduce}, #{serviceStartTime}, #{serviceEndTime}, #{addTime}, #{remarks})")
    void insert(Enterprise enterprise);

    @Select("select * from enterprise where name=#{name}")
    Enterprise findByName(@Param("name") String name);

    @Select("select * from enterprise where id=#{id}")
    Enterprise findById(@Param("id") Long enpId);

    @Update("update enterprise " +
            "set name=#{name}, introduce=#{introduce}, service_start_time=#{serviceStartTime}, " +
            "service_end_time=#{serviceEndTime}, addtime=#{addTime}, remarks=#{remarks} " +
            "where id=#{id}")
    void updateById(Enterprise enterprise);
}
