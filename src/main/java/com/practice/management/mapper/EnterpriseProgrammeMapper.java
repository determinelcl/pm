package com.practice.management.mapper;

import com.practice.management.bean.dto.AddEpDto;
import com.practice.management.bean.dto.UpdEpDto;
import com.practice.management.bean.entity.EnterpriseProgramme;
import com.practice.management.bean.model.EpQueryModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseProgrammeMapper {

    @Select("select * from enterpriseprogramme where id=#{id}")
    EnterpriseProgramme findById(@Param("id") Long programmeId);

    @Insert("insert into enterpriseprogramme(name, enclosure, add_time, remarks, enterprise_id)" +
            "values(#{name}, #{enclosure}, #{addTime}, #{remarks}, #{enterpriseId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(AddEpDto dto);

    @Update("update enterpriseprogramme " +
            "set name=#{name}, enclosure=#{enclosure}, remarks=#{remarks} " +
            "where id=#{epId}")
    void updateById(UpdEpDto dto);

    @Delete("delete from enterpriseprogramme where id=#{id}")
    void deleteById(@Param("id") Long epId);

    @Select("<script>" +
            "select * from enterpriseprogramme " +
            "where 1=1 " +
            "<if test=\"epName != null\"> " +
            "   and name=#{epName}" +
            "</if>" +
            "<if test=\"enterpriseName != null\"> " +
            "   and enterprise_id in (select id from enterprise where name=#{enterpriseName})" +
            "</if>" +
            "<if test=\"enterpriseId != null\"> " +
            "   and enterprise_id=#{enterpriseId}" +
            "</if>" +
            "</script>")
    List<EnterpriseProgramme> queryByCondition(EpQueryModel queryCondition);

    @Select("select * from enterpriseprogramme where name=#{name} and enterprise_id=#{enterpriseId}")
    List<EnterpriseProgramme> findByNameAndEnterpriseId(
            @Param("name") String name, @Param("enterpriseId") Long enterpriseId);
}
