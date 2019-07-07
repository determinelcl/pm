package com.practice.management.controller;

import com.practice.management.bean.entity.Menu;
import com.practice.management.bean.model.MenuQueryModel;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询功能菜单
     * 角色：admin/企业负责人/学校负责人
     *
     * @param queryCondition 查询条件对象
     * @return 查询的菜单列表
     */
    @GetMapping("/query")
    public ResultModel<List<Menu>> query(@RequestBody MenuQueryModel queryCondition) {
        List<Menu> menuList = menuService.query(queryCondition);
        return success("查询完成", menuList);
    }
}
