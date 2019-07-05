package com.practice.management.mapper;

import com.practice.management.bean.dto.AddTsDto;
import com.practice.management.bean.dto.UpdTsDto;
import com.practice.management.bean.entity.TrainScore;
import com.practice.management.bean.model.TsQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PracticeScoreMapper {

    @Insert("insert into trainscore(lesson_name, stage_one, stage_two, stage_three, stage_four, stage_fire, " +
            "                       coefficient_id, major_id, school_id, student_id, enterprise_id)" +
            "values(#{lessonName}, #{stageOne}, #{stageTwo}, #{stageThree}, #{stageFour}, #{stageFire}, " +
            "       #{coefficientId}, #{majorId}, #{schoolId}, #{studentId}, #{enterpriseId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(AddTsDto dto);

    @Select("select * from trainscore where id=#{id}")
    TrainScore findById(@Param("id") Long tsId);

    @Update("update trainscore " +
            "set lesson_name =#{lessonName}, stage_one=#{stageOne}, stage_two=#{stageTwo}, " +
            "       stage_three=#{stageThree}, stage_four=#{stageFour}, stage_fire=#{stageFire}, " +
            "       coefficient_id=#{coefficientId} " +
            "where id=#{tsId}")
    void updateById(UpdTsDto dto);

    @Delete("delete from trainscore where id=#{id}")
    void deleteById(@Param("id") Long tsId);

    @Select("<script>" +
            "select * from trainscore " +
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
            "<if test=\"majorName != null\"> " +
            "   and major_id in (select id from major where name=#{majorName})" +
            "</if>" +
            "<if test=\"lessonName != null\"> " +
            "   and lesson_name=#{lessonName}" +
            "</if>" +
            "<if test=\"schoolName != null\"> " +
            "   and school_id in (select id from school where name=#{schoolName})" +
            "</if>" +
            "<if test=\"coefficientId != null\"> " +
            "   and coefficient_id in (select id from coefficient where id=#{coefficientId})" +
            "</if>" +
            "</script>")
    List<TrainScore> queryByCondition(TsQueryModel queryCondition);


}
