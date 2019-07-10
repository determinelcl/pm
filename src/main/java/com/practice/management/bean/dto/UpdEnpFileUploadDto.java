package com.practice.management.bean.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdEnpFileUploadDto {
    @NotNull(message = "企业老师id不能为空")
    private Long erId;
    @NotNull(message = "文件id不能为空")
    private Long fileId;
    @NotBlank(message = "文件标题不能为空")
    private String title;
    private String enclosure;
    private MultipartFile file;
    @NotNull(message = "学校id不能为空")
    private Long schoolId;
    @NotNull(message = "文件类型id不能为空")
    private Long fileTypeId;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }
}
