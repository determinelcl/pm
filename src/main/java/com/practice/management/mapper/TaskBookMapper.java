package com.practice.management.mapper;

import com.practice.management.bean.dto.AddTaskDto;
import com.practice.management.bean.dto.UpdErTaskDto;
import com.practice.management.bean.dto.UpdSrTaskDto;
import com.practice.management.bean.dto.UpdStuTaskDto;
import com.practice.management.bean.entity.Task;
import com.practice.management.bean.model.TaskQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskBookMapper {

    @Select("select * from task where id=#{id}")
    Task findById(@Param("id") Long taskId);

    @Insert("insert into task(project_name, year, submit_time, enterprise_teacher_name, school_teacher_name," +
            "                   train_content, project_design_content, design_requirement, enclosure_url, " +
            "                   enterprise_opinion, school_examine, enterprise_id, school_id, student_id)" +
            "values(#{projectName}, #{year}, #{submitTime}, #{enterpriseTeacherName}, #{schoolTeacherName}," +
            "       #{trainContent}, #{projectDesignContent}, #{designRequirement}, #{enclosureUrl}," +
            "       #{enterpriseOpinion}, #{schoolExamine}, #{enterpriseId}, #{schoolId}, #{studentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(AddTaskDto task);

    @Update("update task " +
            "set project_name=#{projectName}, project_design_content=#{projectDesignContent}, " +
            " train_content=#{trainContent}, design_requirement=#{designRequirement}, enclosure_url=#{enclosureUrl} " +
            "where id=#{taskId}")
    void updateByStu(UpdStuTaskDto dto);

    @Update("update task " +
            "set school_examine=#{schoolExamine} " +
            "where id=#{taskId}")
    void updateBySr(UpdSrTaskDto dto);

    @Update("update task " +
            "set enterprise_opinion=#{enterpriseOpinion} " +
            "where id=#{taskId}")
    void updateByEr(UpdErTaskDto dto);

    @Delete("delete from task where id=#{id}")
    void deleteById(@Param("id") Long taskId);

    @Select("<script>" +
            "select * from task " +
            "where 1=1 " +
            "<if test=\"type == 1\"> " +
            "   and student_id=#{id} " +
            "</if>" +
            "<if test=\"type == 2\"> " +
            "   and school_id=#{id} " +
            "</if>" +
            "<if test=\"type == 3\"> " +
            "   and enterprise_id=#{id} " +
            "</if>" +
            "<if test=\"account != null\"> " +
            "   and student_id in (select id from student where account=#{account})" +
            "</if>" +
            "<if test=\"submitTime != null\"> " +
            "   and submit_time=#{submitTime}" +
            "</if>" +
            "<if test=\"schoolName != null\"> " +
            "   and school_id in (select id from school where name=#{schoolName})" +
            "</if>" +
            "<if test=\"enpName != null\"> " +
            "   and enterprise_id in (select id from enterprise where name=#{enpName})" +
            "</if>" +
            "<if test=\"projectName != null\"> " +
            "   and project_name=#{projectName}" +
            "</if>" +
            "</script>")
    List<Task> queryByCondition(TaskQueryModel queryCondition);
}
