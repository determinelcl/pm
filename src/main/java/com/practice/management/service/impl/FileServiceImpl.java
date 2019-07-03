package com.practice.management.service.impl;

import com.practice.management.config.FileProperties;
import com.practice.management.exception.FileException;
import com.practice.management.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    private final Path fileStorageLocation;

    @Autowired
    public FileServiceImpl(FileProperties fileProperties) {
        this.fileStorageLocation = Paths.get(fileProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileException("创建存储上传文件的文件夹失败！", ex);
        }
    }

    @Override
    public String saveFile(MultipartFile file, String identification) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // 检查文件名是否包含不合法字符
            if (fileName.contains(".."))
                throw new FileException("Filename contains invalid path sequence " + fileName);

            // 保存文件，覆盖掉明明重复的文件
            String realPath = identification + "_" + fileName;
            Path targetLocation = this.fileStorageLocation.resolve(realPath);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return realPath;
        } catch (IOException ex) {
            throw new FileException("文件上传失败：" + fileName + "，请重试!", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists())
                return resource;
            else
                throw new FileException("文件不存在：" + fileName);
        } catch (MalformedURLException ex) {
            throw new FileException("文件不存在：" + fileName, ex);
        }
    }


    @Override
    public boolean removeFile(String filename) {
        File file = new File(filename);

        if (!file.exists())
            throw new FileException("文件" + filename + "不存在");

        return file.delete();
    }

}
