package com.practice.management.mapper;

import com.practice.management.bean.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("select * from student where account=#{account} and major_id=#{majorId}")
    Student findByAccountAndMajorId(String account, Long majorId);
}
