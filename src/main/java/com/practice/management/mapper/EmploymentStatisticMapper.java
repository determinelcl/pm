package com.practice.management.mapper;

import com.practice.management.bean.dto.AddEmploymentDto;
import com.practice.management.bean.dto.UpdEmploymentDto;
import com.practice.management.bean.entity.Employment;
import com.practice.management.bean.model.EmploymentQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmploymentStatisticMapper {

    @Select("select * from employment where student_id=#{id}")
    Employment findByStudentId(@Param("id") Long stuId);

    @Select("select * from employment where id=#{id}")
    Employment findById(@Param("id") Long eId);

    @Insert("insert into employment(employment_name, city, post, salary, " +
            "           add_time, remarks, enterprise_id, student_id)" +
            " values(#{name}, #{city}, #{post}, #{salary}, #{addTime}, #{remarks}, #{enterpriseId}, #{studentId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(AddEmploymentDto dto);


    @Update("update employment " +
            "set name=#{eName}, city=#{city}, post=#{post}, salary=#{salary}, remarks=#{remarks} " +
            "where id=#{eId}")
    void updateById(UpdEmploymentDto dto);


    @Select("<script>" +
            "select * from employment " +
            "where 1=1 " +
            "<if test=\"type == 1\"> " +
            "   and student_id=#{id} " +
            "</if>" +
            "<if test=\"type == 2\"> " +
            "   and student_id in (select id from student " +
            "           where major_id in (select id from major where school_id=#{id}))" +
            "</if>" +
            "<if test=\"type == 3\"> " +
            "   and enterprise_id=#{id} " +
            "</if>" +
            "<if test=\"salary != null\"> " +
            "   and salary=#{salary}" +
            "</if>" +
            "<if test=\"addTime != null\"> " +
            "   and add_time=#{addTime}" +
            "</if>" +
            "<if test=\"schoolName != null\"> " +
            "   and student_id in (select id from student where major_id in " +
            "           (select id from major where school_id in (select id from school where name=#{schoolName})" +
            "</if>" +
            "<if test=\"enpName != null\"> " +
            "   and enterprise_id in (select id from enterprise where name=#{enpName})" +
            "</if>" +
            "<if test=\"city != null\"> " +
            "   and city=#{city}" +
            "</if>" +
            "<if test=\"post != null\"> " +
            "   and city=#{post}" +
            "</if>" +
            "</script>")
    List<Employment> queryByCondition(EmploymentQueryModel queryCondition);
}
