package com.practice.management.mapper;

import com.practice.management.bean.dto.AddEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdEnterpriseTeacherDto;
import com.practice.management.bean.dto.UpdErDto;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EnpQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseResponsibilityMapper {

    @Select("select * from enterpriseresponsibility where id=#{id}")
    EnterpriseResponsibility findById(@Param("id") Long id);

    @Insert("insert into enterpriseresponsibility(name, age, gender, rank, phone, email, account, password, " +
            "                                                       enterprise_id, role_id, add_time, remarks) " +
            "   values(#{account.name}, #{account.age}, #{account.gender}, #{account.rank}, #{account.phone}, " +
            "       #{account.email}, #{account.account}, #{account.password}, #{account.enterpriseId}, " +
            "       #{account.roleId}, #{account.addTime}, #{account.remarks})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(@Param("account") AddEnterpriseTeacherDto dto);

    @Update("update enterpriseresponsibility " +
            "set name=#{name}, age=#{age}, gender=#{gender}, rank=#{rank}, phone=#{phone}, " +
            "email=#{email},  remarks=#{remarks} where id=#{erId} ")
    void updateErById(UpdErDto dto);


    @Update("update enterpriseresponsibility " +
            "set name=#{name}, age=#{age}, gender=#{gender}, rank=#{rank}, phone=#{phone}, " +
            "email=#{email}, role_id=#{roleId},  remarks=#{remarks} where id=#{etId} ")
    void updateErTeacherById(UpdEnterpriseTeacherDto dto);

    @Delete("delete from enterpriseresponsibility where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Select("<script>" +
            "select * from enterpriseresponsibility " +
            "where 1=1 " +
            "<if test=\"enpId != null\"> " +
            "   and enterprise_id=#{enpId}" +
            "</if>" +
            "<if test=\"account != null\"> " +
            "   and account=#{account}" +
            "</if>" +
            "<if test=\"name != null\"> " +
            "   and name=#{name}" +
            "</if>" +
            "</script>")
    List<EnterpriseResponsibility> queryByCondition(EnpQueryModel queryCondition);
}
