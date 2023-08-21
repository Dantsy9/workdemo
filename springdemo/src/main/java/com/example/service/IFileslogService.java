package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Fileslog;

/**
 * <p>
 * 文件表 服务类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-19
 */
public interface IFileslogService extends IService<Fileslog> {

    /**
     * 文件日志记录
     * @date: 2023/8/21
     * @param: 操作名，文件名，文件大小，文件扩展名
     * @return: void
     **/
    void saveFilesLog(String fileName,String fileSize,String fileExtension);
}
