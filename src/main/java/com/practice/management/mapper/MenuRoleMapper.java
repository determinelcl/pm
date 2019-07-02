package com.practice.management.mapper;

import com.practice.management.bean.entity.MenuRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRoleMapper {

    @Insert("add into menurole(menu_id, role_id) " +
            "values(#{menuId}, #{roleId})")
    void add(MenuRole menuRole);
}
