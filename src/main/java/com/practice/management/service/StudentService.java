package com.practice.management.service;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.entity.Student;

public interface StudentService {
    /**
     * 根据学校添加学生信息
     *
     * @param dto 学生信息对象
     * @param schoolId 学校id
     * @return 添加之后的结果
     */
    Student addStudent(AddStudentDto dto, Long schoolId);
}
