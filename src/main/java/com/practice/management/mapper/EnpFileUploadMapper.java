package com.practice.management.mapper;

import com.practice.management.bean.dto.AddEnpFileUploadDto;
import com.practice.management.bean.dto.UpdEnpFileUploadDto;
import com.practice.management.bean.entity.FileUpload;
import com.practice.management.bean.model.QueryEnpFileUploadModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnpFileUploadMapper {

    @Insert("insert into fileupload(title, year, enclosure, submit_time, enterprise_id, filetype_id, school_id)" +
            "values(#{title}, #{year}, #{enclosure}, #{submitTime}, #{enterpriseId}, #{fileTypeId}, #{schoolId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(AddEnpFileUploadDto dto);

    @Select("select * from fileupload where id=#{id}")
    FileUpload findById(@Param("id") Long fileId);

    @Update("update fileupload " +
            "set title=#{title}, enclosure=#{enclosure}, filetype_id =#{fileTypeId}, school_id=#{schoolId} " +
            "where id=#{fileId}")
    void updateById(UpdEnpFileUploadDto dto);

    @Delete("delete from fileupload where id=#{id}")
    void deleteById(@Param("id") Long fileId);

    @Select("<script>" +
            "select * from fileupload " +
            "where 1=1 " +
            "<if test=\"submitTime != null\"> " +
            "   and submit_time=#{submitTime} " +
            "</if>" +
            "<if test=\"fileType != null\"> " +
            "   and filetype_id in (select id from filetype where type_name=#{fileType})" +
            "</if>" +
            "<if test=\"schoolName != null\"> " +
            "   and school_id in (select id from school where name=#{schoolName})" +
            "</if>" +
            "<if test=\"enterpriseId != null\"> " +
            "   and enterprise_id=#{enterpriseId}" +
            "</if>" +
            "</script>")
    List<FileUpload> queryByCondition(QueryEnpFileUploadModel queryCondition);
}
