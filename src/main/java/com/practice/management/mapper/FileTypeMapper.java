package com.practice.management.mapper;

import com.practice.management.bean.entity.FileType;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FileTypeMapper {

    @Select("select * from filetype where id=#{id}")
    FileType findById(@Param("id") Long fileTypeId);

    @Select("select * from filetype where type_name=#{name}")
    FileType findByName(@Param("name") String typeName);

    @Insert("insert into filetype(type_name) values(#{typeName})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long insert(FileType fileType);
}
