package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-10
 */

public interface LogMapper extends BaseMapper<Log> {

    /**
     * 日志信息添加到数据库
     * @date: 2023/8/10
     * @param: [log]
     * @return: int
     **/
    int insertInfo(Log log);
}
