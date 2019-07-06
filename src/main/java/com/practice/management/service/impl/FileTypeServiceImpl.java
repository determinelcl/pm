package com.practice.management.service.impl;

import com.practice.management.bean.entity.FileType;
import com.practice.management.mapper.FileTypeMapper;
import com.practice.management.service.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileTypeServiceImpl implements FileTypeService {

    @Autowired
    private FileTypeMapper fileTypeMapper;

    @Override
    public FileType findById(Long fileTypeId) {
        FileType fileType = fileTypeMapper.findById(fileTypeId);
        if (fileType == null)
            throw new RuntimeException("文件类型id:" + fileTypeId + "不存在");

        return fileType;
    }

    @Override
    public FileType save(FileType fileType) {
        FileType temp = fileTypeMapper.findByName(fileType.getTypeName());
        if (temp != null)
            throw new RuntimeException("文件类型:" + fileType.getTypeName() + "已存在");

        Long fileTypeId = fileTypeMapper.insert(fileType);
        fileType.setId(fileTypeId);
        return fileType;
    }
}
