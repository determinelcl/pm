package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdSrStudentDto;
import com.practice.management.bean.dto.UpdStudentDto;
import com.practice.management.bean.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {

    @Select("select * from student where account=#{account} and major_id=#{majorId}")
    Student findByAccountAndMajorId(@Param("account") String account, @Param("majorId") Long majorId);

    @Select("select * from student where id=#{id}")
    Student findById(@Param("id") Long stuId);

    @Update("update student " +
            "set name=#{name}, age=#{age}, gender=#{gender}, phone=#{phone}, email=#{email}, remarks=#{remarks}" +
            "where id=#{stuId}")
    void updStudentById(UpdStudentDto dto);

    @Update("update student " +
            "set name=#{name}, age=#{age}, gender=#{gender}, phone=#{phone}, email=#{email}, classes=#{classes}, " +
            "   remarks=#{remarks}, major_id=#{majorId}, role_id=#{roleId}, enterprise_id=#{enterpriseId}, " +
            "   enterprise_programme_id=#{enterpriseProgrammeId} " +
            "where id=#{stuId}")
    void updStudentBySr(UpdSrStudentDto dto);


}
