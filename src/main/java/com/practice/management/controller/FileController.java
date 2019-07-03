package com.practice.management.controller;

import com.practice.management.bean.dto.ResultModel;
import com.practice.management.bean.dto.UploadFileResponseModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResultModel<UploadFileResponseModel> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.saveFile(file, "sno");

        // 根据上传的文件路径生成下载路径
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/download/")
                .path(fileName)
                .toUriString();

        return success(new UploadFileResponseModel(fileName, fileDownloadUri,
                file.getContentType(), file.getSize()));
    }


    @PostMapping("/upload/batch")
    public ResultModel<List<UploadFileResponseModel>> uploadMultiFiles(@RequestParam("files") MultipartFile[] files) {
        return success(Arrays.stream(files)
                .map(file -> uploadFile(file).getResult())
                .collect(Collectors.toList()));
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // 将文件加载成Resource对象
        Resource resource = fileService.loadFileAsResource(fileName);

        // 获取文件的MIME类型
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("未获取到文件的MIME类型.");
        }

        // 如果不知道文件的MIME类型，则自动设置MIME类型
        if (contentType == null)
            contentType = "application/octet-stream";


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
