package com.practice.management.service;

import com.practice.management.bean.entity.FileType;

public interface FileTypeService {

    /**
     * 根据id查询文件类型
     *
     * @param fileTypeId 文件类型id
     * @return 文件类型对象
     */
    FileType findById(Long fileTypeId);

    /**
     * 添加文件类型
     *
     * @param fileType 文件类型对象
     * @return 添加完成的文件类型对象
     */
    FileType save(FileType fileType);
}
