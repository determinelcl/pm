package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddEnpFileUploadDto;
import com.practice.management.bean.dto.UpdEnpFileUploadDto;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.entity.FileType;
import com.practice.management.bean.entity.FileUpload;
import com.practice.management.bean.model.QueryEnpFileUploadModel;
import com.practice.management.constrant.FileConstrant;
import com.practice.management.mapper.EnpFileUploadMapper;
import com.practice.management.service.*;
import com.practice.management.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EnpFileUploadServiceImpl implements EnpFileUploadService {

    @Autowired
    private EnpFileUploadMapper uploadMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Autowired
    private FileTypeService fileTypeService;

    @Autowired
    private SchoolEnterpriseService seService;

    @Autowired
    private SchoolService schoolService;

    @Override
    public FileUpload add(AddEnpFileUploadDto dto) {
        EnterpriseResponsibility er = erService.findById(dto.getErId());
        dto.setEnterpriseId(er.getEnterpriseId());

        // 验证/保存文件类型
        if (dto.getFileTypeId() != null)
            fileTypeService.findById(dto.getFileTypeId());
        else {
            FileType fileType = fileTypeService.save(dto.getFiletype());
            dto.setFileTypeId(fileType.getId());
        }

        // 验证学校是否存在以及校企合作
        schoolService.findById(dto.getSchoolId());
        seService.findByScIdAndEnpId(dto.getSchoolId(), dto.getEnterpriseId());

        Date date = new Date();
        String identification = dto.getEnterpriseId() + "_" + date.getTime();
        String fileName = fileService.saveFile(dto.getFile(), identification);
        dto.setEnclosure(fileName);
        dto.setYear(String.valueOf(Calendar.YEAR));
        dto.setSubmitTime(date);

        Long fileId = uploadMapper.insert(dto);
        return uploadMapper.findById(fileId);
    }

    @Override
    public FileUpload findById(Long fileId) {
        FileUpload fileUpload = uploadMapper.findById(fileId);
        if (fileUpload == null)
            throw new RuntimeException("文件id:" + fileId + "不存在");

        return fileUpload;
    }

    @Override
    public FileUpload update(UpdEnpFileUploadDto dto) {
        Long fileId = dto.getFileId();
        FileUpload fileUpload = validateErAuthority(dto.getErId(), fileId);

        // 验证学校是否存在以及校企合作
        schoolService.findById(dto.getSchoolId());
        seService.findByScIdAndEnpId(dto.getSchoolId(), fileUpload.getEnterpriseId());

        fileTypeService.findById(dto.getFileTypeId());

        if (dto.getFile() != null) {
            Date date = new Date();
            String identification = fileUpload.getEnterpriseId() + "_" + date.getTime();
            String fileName = fileService.saveFile(dto.getFile(), identification);
            dto.setEnclosure(fileName);
        } else
            dto.setEnclosure(fileUpload.getEnclosure());

        uploadMapper.updateById(dto);
        return uploadMapper.findById(fileId);
    }

    private FileUpload validateErAuthority(Long erId, Long fileId) {
        EnterpriseResponsibility er = erService.findById(erId);
        FileUpload fileUpload = findById(fileId);

        if (!fileUpload.getEnterpriseId().equals(er.getEnterpriseId()))
            throw new RuntimeException("文件:" + fileUpload.getTitle() + "不是企业负责人:" + er.getName() + "上传的");
        return fileUpload;
    }

    @Override
    public FileUpload delete(Long erId, Long fileId) {
        FileUpload fileUpload = validateErAuthority(erId, fileId);
        uploadMapper.deleteById(fileId);

        return fileUpload;
    }

    @Override
    public List<FileUpload> query(QueryEnpFileUploadModel queryCondition) {
        EnterpriseResponsibility er = erService.findById(queryCondition.getErId());
        queryCondition.setEnterpriseId(er.getEnterpriseId());

        List<FileUpload> fileUploadList = uploadMapper.queryByCondition(queryCondition);
        fileUploadList.forEach(file ->
                file.setEnclosure(FileUtil.getFileDownloadUri(file.getEnclosure(), FileConstrant.FILE_DOWNLOAD_URI)));

        return fileUploadList;
    }
}
