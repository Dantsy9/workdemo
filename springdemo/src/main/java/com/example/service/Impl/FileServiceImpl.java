package com.example.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.Fileslog;
import com.example.mapper.FileslogMapper;
import com.example.service.FileService;
import com.example.service.IFileslogService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author zmc
 * @since 2023-08-18
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private IFileslogService iFileslogService;

    /**
     * 上传
     * @date: 2023/8/21
     * @param: [image]
     * @return: void //TODO 无返回吗
     **/
    @Override
    public void uploadFile(MultipartFile image) {
        //获得文件原始名称
        String originalFilename = image.getOriginalFilename();
        //获取文件的扩展名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        //文件大小
        long size = image.getSize();
        String fileSize = String.valueOf(size);
        //构建新的文件名称，UUID为唯一标识
        String newFileName = UUID.randomUUID() + extname;
        //上传文件
        try {
            //TODO 路径使用配置文件读取的方式获取
            image.transferTo(new File("D:\\temp\\IdeaUpload\\"+newFileName));
            iFileslogService.saveFilesLog(newFileName,fileSize,extname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 下载
     * @date: 2023/8/21
     * @param: 文件名
     * @return: 响应
     **/
    @Override
    public ResponseEntity<Object> downloadFile(String fileName) {
        String filePath = "D:\\temp\\IdeaUpload\\";
        File file = new File(filePath + fileName);
        InputStreamResource resource = null;
        //文件大小
        long length = file.length();
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", file.getName()));
        //设置响应体
        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers(headers)
                .contentLength(length)//文件总大小
                .contentType(MediaType.parseMediaType("application/text"))//文件类型
                .body(resource);
        return responseEntity;
    }
}
