package com.practice.management.mapper;

import com.practice.management.bean.entity.SchoolEnterprise;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SchoolEnterpriseMapper {

    @Select("select * from schoolenterprise where school_id=#{scId} and enterprise_id=#{enpId}")
    SchoolEnterprise findByScIdAndEnpId(@Param("scId") Long scId, @Param("enpId") Long enpId);
}
