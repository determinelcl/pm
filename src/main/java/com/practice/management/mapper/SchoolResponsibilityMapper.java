package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdSchoolTeacherDto;
import com.practice.management.bean.dto.UpdSrDto;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.SrQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolResponsibilityMapper {

    @Select("select * from schoolresponsibility where id=#{id}")
    SchoolResponsibility findById(@Param("id") Long srId);

    @Update("update schoolresponsibility " +
            "set name=#{name}, age=#{age}, gender=#{gender}, rank=#{rank}, phone=#{phone}, " +
            "email=#{email},  remarks=#{remarks} where id=#{srId} ")
    void updateSrById(UpdSrDto dto);


    @Update("update schoolresponsibility " +
            "set name=#{name}, age=#{age}, gender=#{gender}, rank=#{rank}, phone=#{phone}, " +
            "email=#{email}, role_id=#{roleId},  remarks=#{remarks}, school_id=#{majorId} where id=#{stId} ")
    void updateSrTeacherById(UpdSchoolTeacherDto dto);

    @Delete("delete from schoolresponsibility where id=#{id}")
    void deleteById(@Param("id") Long stId);

    @Select("<script>" +
            "select * from schoolresponsibility " +
            "where 1=1 " +
            "<if test=\"schoolId != null\"> " +
            "   and school_id=#{schoolId}" +
            "</if>" +
            "<if test=\"teacherId != null\"> " +
            "   and account=#{teacherId}" +
            "</if>" +
            "<if test=\"teacherName != null\"> " +
            "   and name=#{teacherName}" +
            "</if>" +
            "<if test=\"majorName != null\"> " +
            "   and major_id in (select id from major where name=#{majorName})" +
            "</if>" +
            "</script>")
    List<SchoolResponsibility> queryByCondition(SrQueryModel queryCondition);

    @Select("select * from schoolresponsibility where school_id=#{scId} and account=#{account}")
    SchoolResponsibility findByScIdAndAccount(@Param("scId") Long scId, @Param("account") String account);
}
