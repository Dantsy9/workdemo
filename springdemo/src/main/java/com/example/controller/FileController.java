package com.example.controller;

import com.example.service.FileService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

/**
 * <p>
 * 文件上传 控制层
 * </p>
 *
 * @author zmc
 * @since 2023-08-18
 */

@Slf4j
@RestController
public class FileController {

    @Resource
    private FileService fileService;


    /**
     * 文件上传
     * @date: 2023/8/18
     * @param: file
     * @return: 上传结果
     **/
    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartFile image){

        fileService.uploadFile(image);

        return Result.success();
    }
    //TODO
    /**
     * 文件下载
     * @date: 2023/8/28
     * @param: 文件名称
     * @return: 请求体
     **/
    @GetMapping("/download")
    //TODO  返回对象没统一
    public ResponseEntity<Object>  downloadFile(String fileName){
        ResponseEntity<Object> response = fileService.downloadFile(fileName);
        return response;
    }
}
