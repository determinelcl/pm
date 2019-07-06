package com.practice.management.bean.entity;

import java.util.Date;

/*
 * 文件上传
 * */
public class FileUpload {
    private Long id;
    private String title;
    private String year;
    private String enclosure;
    private Date submitTime;
    private Long enterpriseId;
    private Long fileTypeId;
    private Long schoolId;

    // 文件的类型，非属性字段
    private FileType filetype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public FileType getFiletype() {
        return filetype;
    }

    public void setFiletype(FileType filetype) {
        this.filetype = filetype;
    }
}
