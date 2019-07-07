package com.practice.management.service.impl;

import com.practice.management.bean.entity.Menu;
import com.practice.management.bean.model.MenuQueryModel;
import com.practice.management.mapper.MenuMapper;
import com.practice.management.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> query(MenuQueryModel queryCondition) {

        return menuMapper.queryByCondition(queryCondition);
    }
}
