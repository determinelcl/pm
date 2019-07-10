package com.practice.management.mapper;

import com.practice.management.bean.dto.AddWtDto;
import com.practice.management.bean.dto.UpdWtDto;
import com.practice.management.bean.entity.WeekTrain;
import com.practice.management.bean.model.WtQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface WeekTrainMapper {

    @Select("select * from weektrain where id=#{id}")
    WeekTrain findById(@Param("id") Long wtId);


    @Select("select * from weektrain where enterprise_id=#{enterpriseId} " +
            "       and major_id=#{majorId} and start_time <= #{startTime} and end_time >= #{endTime}")
    WeekTrain findByMajorIdAndSeTime(@Param("enterpriseId") Long enterpriseId, @Param("majorId") Long majorId,
                                     @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Insert("insert into weektrain(train_times, train_number, start_time, end_time, base_name, week_teach, " +
            "           week_student_learn, feedback_focus, train_assessment_situation, enterprise_id, major_id)" +
            " values(#{trainTimes},#{trainNumber}, #{startTime}, #{endTime}, #{baseName}, #{weekTeach}, " +
            "       #{weekStudentLearn}, #{feedbackFocus}, #{trainAssessmentSituation}, #{enterpriseId}, #{majorId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(AddWtDto dto);

    @Update("update weektrain " +
            "set train_times=#{trainTimes}, train_number=#{trainNumber}, base_name=#{baseName}, " +
            "       week_teach=#{weekTeach}, week_student_learn=#{weekStudentLearn}, feedback_focus=#{feedbackFocus}, " +
            "       train_assessment_situation=#{trainAssessmentSituation} " +
            "where id=#{wtId}")
    void updateById(UpdWtDto dto);

    @Delete("delete from weektrain where id=#{id}")
    void deleteById(@Param("id") Long wtId);

    @Select("<script>" +
            "select * from weektrain " +
            "where 1=1 " +
            "<if test=\"type == 1\"> " +
            "   and major_id in (select major_id from student where id=#{id})" +
            "</if>" +
            "<if test=\"type == 2\"> " +
            "   and major_id in (select major_id from schoolresponsibility where id=#{id})" +
            "</if>" +
            "<if test=\"type == 3\"> " +
            "   and enterprise_id in (select enterprise_id from enterpriseresponsibility where id=#{id}) " +
            "</if>" +
            "<if test=\"majorName != null\"> " +
            "   and major_id in (select id from major where name=#{majorName})" +
            "</if>" +
            "<if test=\"enpName != null\"> " +
            "   and enterprise_id in (select id from enterprise where name=#{enpName})" +
            "</if>" +
            "<if test=\"time != null\"> " +
            "   and <![CDATA[ start_time <= #{time} and end_time >= #{time} ]]>" +
            "</if>" +
            "</script>")
    List<WeekTrain> queryByCondition(WtQueryModel queryCondition);
}
