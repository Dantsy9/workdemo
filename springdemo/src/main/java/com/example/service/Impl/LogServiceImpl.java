package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Log;
import com.example.mapper.LogMapper;
import com.example.service.ILogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-10
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
