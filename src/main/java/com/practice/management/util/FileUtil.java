package com.practice.management.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class FileUtil {
    /**
     * 根据指定的文件名生成对应的下载路径
     *
     * @param fileName 文件名
     * @param downloadUri 下载的action
     * @return 生成的下载uri
     */
    public static String getFileDownloadUri(String fileName, String downloadUri) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(downloadUri)
                .path(fileName)
                .toUriString();
    }
}
