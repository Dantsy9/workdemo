package com.example.service.Impl;


import com.example.domain.Fileslog;
import com.example.mapper.FileslogMapper;
import com.example.service.IFileslogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private HttpServletRequest request;

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
        //解析token获取当前用户
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        String operator = claims.get("username",String.class);
        Fileslog fileslog = new Fileslog();
        fileslog.setFileName(fileName);
        fileslog.setOperator(operator);
        fileslog.setOperationTime(LocalDateTime.now());
        fileslog.setFileSize(fileSize);
        fileslog.setFileExtension(fileExtension);
        fileslogMapper.insert(fileslog);
    }
}
