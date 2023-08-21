package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件上传下载 服务类
 * </p>
 *
 * @author zmc
 * @since 2023-08-18
 */


public interface FileService {
    /**
     * 文件上传
     * @date: 2023/8/18
     * @param:
     * @return:
     **/
    void uploadFile(MultipartFile image);

    /**
     * 文件下载
     * @date: 2023/8/18
     * @param:
     * @return:
     **/
    ResponseEntity<Object> downloadFile(String fileName);
}
