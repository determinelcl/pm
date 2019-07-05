package com.practice.management.bean.dto;

import com.practice.management.bean.entity.Task;
import org.springframework.web.multipart.MultipartFile;

public class AddTaskDto extends Task {

    private MultipartFile enclosureFile;

    public MultipartFile getEnclosureFile() {
        return enclosureFile;
    }

    public void setEnclosureFile(MultipartFile enclosureFile) {
        this.enclosureFile = enclosureFile;
    }
}
