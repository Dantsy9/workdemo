package com.example.service.Impl;


import com.example.domain.Fileslog;
import com.example.mapper.FileslogMapper;
import com.example.service.IFileslogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-19
 */
@Service
public class FileslogServiceImpl extends ServiceImpl<FileslogMapper, Fileslog> implements IFileslogService {

    @Resource
    private FileslogMapper fileslogMapper;

    /**
     * 文件日志记录
     * @date: 2023/8/19
     * @param: 操作名，文件名，文件大小，文件扩展名
     * @return: void
     **/
    @Override
    public void saveFilesLog(String fileName,String fileSize,String fileExtension) {
        //TODO 每次都要解析，有没有办法简化这个环节？ 重复性动作，重复性代码考虑如何进行优化
        Fileslog fileslog = new Fileslog();
        fileslog.setFileName(fileName);

        fileslog.setOperationTime(LocalDateTime.now());
        fileslog.setFileSize(fileSize);
        fileslog.setFileExtension(fileExtension);
        fileslogMapper.insert(fileslog);
    }
}
