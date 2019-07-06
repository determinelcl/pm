package com.practice.management.bean.dto;

import com.practice.management.bean.entity.EnterpriseProgramme;
import org.springframework.web.multipart.MultipartFile;

public class AddEpDto extends EnterpriseProgramme {
    private Long erId;

    private MultipartFile file;

    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
