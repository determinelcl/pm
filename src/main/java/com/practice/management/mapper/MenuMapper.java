package com.practice.management.mapper;

import com.practice.management.bean.entity.Menu;
import com.practice.management.bean.model.MenuQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from menu where id in (" +
            "select menu_id from menurole where role_id=#{roleId})")
    List<Menu> findByRoleId(@Param("roleId") Long roleId);

    @Insert("add into menu(sequence, logo, menu_name, menu_url, menu_parent, menu_level) " +
            "values(#{sequence}, #{logo}, #{menuName}, #{menuUrl}, #{menuParent}, #{menuLevel})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long add(Menu menu);

    @Select("<script>" +
            "select * from menu " +
            "where 1=1 " +
            "<if test=\"menuName != null\"> " +
            "   and menu_name=#{menuName} " +
            "</if>" +
            "and id in (select menu_id from menurole where role_id in (" +
            "   select role_id from " +
            "   <if test=\"type == 0\"> " +
            "      admin where id=#{id} " +
            "   </if>" +
            "   <if test=\"type == 1\"> " +
            "      student where id=#{id} " +
            "   </if>" +
            "   <if test=\"type == 2\"> " +
            "      schoolresponsibility where id=#{id} " +
            "   </if>" +
            "   <if test=\"type == 3\"> " +
            "      enterpriseresponsibility where id=#{id} " +
            "   </if>" +
            "))" +
            "</script>")
    List<Menu> queryByCondition(MenuQueryModel queryCondition);
}
