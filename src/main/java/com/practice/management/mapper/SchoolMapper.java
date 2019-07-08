package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdSchoolParamDto;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.model.SchoolQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Insert("insert into school(name, introduce, service_start_time, service_end_time, add_time, account, remarks) " +
            "values(#{name}, #{introduce}, #{serviceStartTime}, #{serviceEndTime}, #{addTime}, #{account}, #{remarks})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(School school);

    @Select("select * from school where name=#{name}")
    School findByName(@Param("name") String name);

    @Select("select * from school where id=#{id}")
    School findById(@Param("id") Long schoolId);

    @Select("update school " +
            "set name=#{name}, introduce=#{introduce} remarks=#{remarks} " +
            "where id=#{id}")
    void updateSchoolById(UpdSchoolParamDto school);

    @Select("<script>" +
            "select * from school " +
            "where 1=1 " +
            "<if test=\"schoolName != null\"> " +
            "   and name like '%#{schoolName}%'" +
            "</if>" +
            "</script>")
    List<School> queryByCondition(SchoolQueryModel queryCondition);
}
