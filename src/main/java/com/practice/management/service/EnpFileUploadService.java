package com.practice.management.service;

import com.practice.management.bean.dto.AddEnpFileUploadDto;
import com.practice.management.bean.dto.UpdEnpFileUploadDto;
import com.practice.management.bean.entity.FileUpload;
import com.practice.management.bean.model.QueryEnpFileUploadModel;

import java.util.List;

public interface EnpFileUploadService {
    /**
     * 上传文件
     * 角色：企业负责人/老师
     *
     * @param dto 上传的文件对象
     * @return 上传的文件对象
     */
    FileUpload add(AddEnpFileUploadDto dto);

    /**
     * 根据id查询上传的文件
     *
     * @param fileId 上传的文件id
     * @return 上传的文件对象
     */
    FileUpload findById(Long fileId);

    /**
     * 修改上传文件
     * 角色：企业负责人/老师
     *
     * @param dto 修改的文件对象
     * @return 修改完成的文件对象
     */
    FileUpload update(UpdEnpFileUploadDto dto);

    /**
     * 删除上传的文件
     * 角色：企业负责人/老师
     *
     * @param erId   企业负责人/老师id
     * @param fileId 删除的文件id
     * @return 成功删除的文件对象
     */
    FileUpload delete(Long erId, Long fileId);

    /**
     * 查询上传文件
     * 角色：企业负责人/老师、学校负责人/老师
     *
     * @param queryCondition 查询条件
     * @return 查询的文件列表
     */
    List<FileUpload> query(QueryEnpFileUploadModel queryCondition);
}
