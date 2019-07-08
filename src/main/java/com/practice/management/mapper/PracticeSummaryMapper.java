package com.practice.management.mapper;

import com.practice.management.bean.dto.AddTrainSummaryDto;
import com.practice.management.bean.dto.UpdStuTrainSummaryDto;
import com.practice.management.bean.entity.TrainSummary;
import com.practice.management.bean.model.TrainSummaryQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PracticeSummaryMapper {

    @Insert("insert into trainsummary(train_summary, train_report_url, train_design_url, school_id, student_id) " +
            "values(#{trainSummary}, #{trainReportUrl}, #{trainDesignUrl}, #{schoolId}, #{studentId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(AddTrainSummaryDto summary);

    @Select("select * from trainsummary where id=#{id}")
    TrainSummary findById(@Param("id") Long summaryId);

    @Update("update trainsummary " +
            "set train_summary=#{trainSummary}, train_report_url=#{trainReportUrl}, " +
            "    train_design_url=#{trainDesignUrl} " +
            "where id=#{tsId}")
    void updateByStu(UpdStuTrainSummaryDto dto);

    @Delete("delete from trainsummary where id=#{id}")
    void deleteById(@Param("id") Long summaryId);

    @Select("<script>" +
            "select * from trainsummary " +
            "where 1=1 " +
            "<if test=\"type == 1\"> " +
            "   and student_id=#{id} " +
            "</if>" +
            "<if test=\"type == 2\"> " +
            "   and school_id=#{id} " +
            "</if>" +
            "<if test=\"account != null\"> " +
            "   and student_id in (select id from student where account=#{account})" +
            "</if>" +
            "<if test=\"schoolName != null\"> " +
            "   and school_id in (select id from school where name=#{schoolName})" +
            "</if>" +
            "</script>")
    List<TrainSummary> queryByCondition(TrainSummaryQueryModel queryCondition);
}
