package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Addlog;
import com.example.domain.AddlogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 增加操作日志表 Mapper 接口
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-11
 */

public interface AddlogMapper extends BaseMapper<Addlog> {
    //获得日期和对应方法的调用次数集合
    @Select("SELECT date_format(operation_time, '%Y-%m-%d') as operationTime , COUNT(method) as countMethodByTime FROM addlog where method=#{method} group by date_format(operation_time, '%Y-%m-%d')")
    List<AddlogDTO> getCountMethodAndOperationTimeByMethod(String method);
    //获得全部操作时间
    @Select("SELECT date_format(operation_time, '%Y-%m-%d') as operationTime FROM addlog group by date_format(operation_time, '%Y-%m-%d') order by date_format(operation_time, '%Y-%m-%d')")
    List<LocalDateTime> getAllOperationTime();
    //获得全部调用的方法名称
    @Select("SELECT method FROM addlog group by method")
    List<String> selectMethod();
}
