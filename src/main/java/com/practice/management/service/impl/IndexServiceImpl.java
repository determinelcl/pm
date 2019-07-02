package com.practice.management.service.impl;

import com.practice.management.bean.entity.Student;
import com.practice.management.bean.entity.Account;
import com.practice.management.mapper.AccountMapper;
import com.practice.management.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public Account login(String username, String password) {

        return null;
    }

    @Override
    public List<Student> studentList() {
        return null;
    }

}
