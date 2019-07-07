package com.practice.management.mapper;

import com.practice.management.bean.entity.MenuRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    @Insert("insert into menurole(menu_id, role_id) " +
            "values(#{menuId}, #{roleId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long add(MenuRole menuRole);

    @Select("select * from menurole where role_id=#{roleId}")
    List<MenuRole> findByRoleId(@Param("roleId") Long roleId);

    @Insert("<script>" +
            "insert into menurole(menu_id, role_id) " +
            "values" +
            "<foreach collection=\"mrList\" item=\"mr\" index=\"index\" separator=\",\">" +
            "   (#{mr.menuId}, #{mr.roleId})" +
            "</foreach>" +
            "</script>")
    void insertBatch(@Param("list") List<MenuRole> menuRoleList);
}
