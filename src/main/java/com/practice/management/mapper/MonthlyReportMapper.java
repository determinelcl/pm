package com.practice.management.mapper;

import com.practice.management.bean.dto.UpdErMReportDto;
import com.practice.management.bean.dto.UpdSrMReportDto;
import com.practice.management.bean.dto.UpdStuMReportDto;
import com.practice.management.bean.entity.MonthReport;
import com.practice.management.bean.model.MonthlyReportQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MonthlyReportMapper {
    @Insert("insert into monthreport(start_time, end_time, train_content, train_harvest, year, enterprise_opinion, " +
            "                       school_examine, submit_time, enterprise_id, school_id, student_id)" +
            " values(#{startTime}, #{endTime}, #{trainContent}, #{trainHarvest}, #{year}, #{enterpriseOpinion}," +
            "           #{schoolExamine}, #{submitTime}, #{enterpriseId}, #{schoolId}, #{studentId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(MonthReport monthReport);

    @Select("select * from monthreport where id=#{id}")
    MonthReport findById(@Param("id") Long monthReportId);

    @Update("update monthreport " +
            "set train_content=#{trainContent}, train_harvest={trainHarvest} " +
            "where id=#{monthReportId}")
    void updateByStu(UpdStuMReportDto dto);

    @Update("update monthreport " +
            "set school_examine=#{schoolExamine} " +
            "where id=#{monthReportId}")
    void updateBySr(UpdSrMReportDto dto);

    @Update("update monthreport " +
            "set enterprise_opinion=#{enterpriseOpinion} " +
            "where id=#{monthReportId}")
    void updateByEr(UpdErMReportDto dto);

    @Delete("delete from monthreport where id=#{id}")
    void deleteById(@Param("id") Long monthReportId);

    @Select("<script>" +
            "select * from monthreport " +
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
            "</script>")
    List<MonthReport> queryByCondition(MonthlyReportQueryModel queryCondition);
}
