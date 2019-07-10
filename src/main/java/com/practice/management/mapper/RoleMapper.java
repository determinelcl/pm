package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdRoleDto;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.RoleQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Insert("insert into role(type, query, save, del, upd, en) " +
            "values(#{type}, #{query}, #{save}, #{del}, #{upd}, #{en})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long add(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(@Param("id") Long id);

    @Update("update role " +
            "set type=#{type}, query=#{query}, save=#{save}, del=#{del}, upd=#{upd}, en=#{en}" +
            "where id=#{roleId}")
    void update(UpdRoleDto dto);

    @Delete("delete from role where id=#{id}")
    void deleteById(@Param("id") Long roleId);

    @Select("<script>" +
            "select * from role " +
            "where 1=1 " +
            "<if test=\"roleName != null\"> " +
            "   and type like concat(concat('%', #{roleName}), '%')" +
            "</if>" +
            "<if test=\"query != null\"> " +
            "   and query=#{query}" +
            "</if>" +
            "<if test=\"save != null\"> " +
            "   and save=#{save}" +
            "</if>" +
            "<if test=\"del != null\"> " +
            "   and del=#{del}" +
            "</if>" +
            "<if test=\"upd != null\"> " +
            "   and upd=#{upd}" +
            "</if>" +
            "</script>")
    List<Role> queryByCondition(RoleQueryModel queryCondition);
}
