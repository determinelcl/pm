package com.practice.management.service;

import com.practice.management.bean.entity.Menu;
import com.practice.management.bean.model.MenuQueryModel;

import java.util.List;

public interface MenuService {

    /**
     * 查询功能菜单
     * 角色：admin/企业负责人/学校负责人
     *
     * @param queryCondition 查询条件对象
     * @return 查询的菜单列表
     */
    List<Menu> query(MenuQueryModel queryCondition);
}
