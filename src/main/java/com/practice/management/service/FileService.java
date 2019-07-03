package com.practice.management.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 存储文件到系统
     *
     * @param file           文件
     * @param identification 唯一标识，添加文件名做限定防止不同用户提交文件时名字引起的明明冲突
     * @return 文件名
     */
    String saveFile(MultipartFile file, String identification);

    /**
     * 加载文件
     *
     * @param fileName 文件名
     * @return 文件
     */
    Resource loadFileAsResource(String fileName);

    /**
     * 删除用户指定的文件
     *
     * @param filename 指定的文件名称
     * @return 删除成功返回true，否则返回false
     */
    boolean removeFile(String filename);
}
