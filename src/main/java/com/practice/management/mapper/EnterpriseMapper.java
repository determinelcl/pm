package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdEnterpriseParamDto;
import com.practice.management.bean.entity.Enterprise;
import com.practice.management.controller.EnterpriseQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into enterprise(name, introduce, service_start_time, service_end_time, add_time, remarks)" +
            "values(#{name}, #{introduce}, #{serviceStartTime}, #{serviceEndTime}, #{addTime}, #{remarks})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(Enterprise enterprise);

    @Select("select * from enterprise where name=#{name}")
    Enterprise findByName(@Param("name") String name);

    @Select("select * from enterprise where id=#{id}")
    Enterprise findById(@Param("id") Long enpId);

    @Update("update enterprise " +
            "set name=#{name}, introduce=#{introduce} remarks=#{remarks} " +
            "where id=#{id}")
    void updateById(UpdEnterpriseParamDto enterprise);

    @Select("<script>" +
            "select * from enterprise " +
            "where 1=1 " +
            "<if test=\"enpName != null\"> " +
            "   and name like '%#{enpName}%'" +
            "</if>" +
            "</script>")
    List<Enterprise> queryByCondition(EnterpriseQueryModel queryCondition);
}
