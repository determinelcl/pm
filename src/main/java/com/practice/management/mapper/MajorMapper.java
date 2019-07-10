package com.practice.management.mapper;

import com.practice.management.bean.dto.AddMajorDto;
import com.practice.management.bean.dto.UpdMajorDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.model.MajorQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MajorMapper {

    @Select("select * from major where id=#{id}")
    Major findById(@Param("id") Long majorId);

    @Select("select * from major where name=#{name} and faculty_name=#{facultyName}")
    List<Major> findByName(@Param("name") String name, @Param("facultyName") String facultyName);

    @Insert("insert into major(faculty_name, name, introduce, school_id)" +
            "values(#{facultyName}, #{name}, #{introduce}, #{schoolId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(AddMajorDto dto);

    @Update("update major " +
            "set faculty_name=#{facultyName}, name=#{name}, introduce=#{introduce} " +
            "where id=#{majorId}")
    void updateById(UpdMajorDto dto);

    @Delete("delete from major where id=#{id}")
    void deleteById(@Param("id") Long majorId);

    @Select("<script>" +
            "select * from major " +
            "where 1=1 " +
            "<if test=\"name != null\"> " +
            "   and name=#{name}" +
            "</if>" +
            "<if test=\"facultyName != null\"> " +
            "   and faculty_name=#{facultyName}" +
            "</if>" +
            "<if test=\"schoolId != null\"> " +
            "   and school_id=#{schoolId}" +
            "</if>" +
            "</script>")
    List<Major> queryByCondition(MajorQueryModel queryCondition);
}
