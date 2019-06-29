package com.practice.management.service.impl;

import com.practice.management.bean.entity.Student;
import com.practice.management.bean.entity.User;
import com.practice.management.mapper.StudentMapper;
import com.practice.management.mapper.UserMapper;
import com.practice.management.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public User login(String username, String password) {

        return null;
    }

    @Override
    public List<Student> studentList() {
        return studentMapper.list();
    }
}
