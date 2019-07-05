package com.practice.management.mapper;

import com.practice.management.bean.entity.Coefficient;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CoefficientMapper {

    @Select("select * from coefficient where id=#{id}")
    Coefficient findById(@Param("id") Long cId);

    @Insert("insert into coefficient(stage_one_coefficient, stage_two_coefficient, stage_three_coefficient, " +
            "                       stage_four_coefficient, stage_fire_coefficient)" +
            "values(#{stageOneC}, #{stageTwoC}, #{stageThreeC}, #{stageFourC}, #{stageFireC})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(Coefficient coefficient);

}
