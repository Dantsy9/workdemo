package com.example.service;


import com.example.domain.AddlogDTO;

import java.util.List;

/**
 * <p>
 * 图表统计 服务类
 * </p>
 *
 * @author Zhuang
 * @since 2023-08-23
 */
public interface LogStatsService {

    /**
     * 统计方法的数据并返回统计数据集合
     * @date: 2023/8/28
     * @param: []
     * @return: 统计数据集合
     **/
    List<AddlogDTO> operatorStats();

}
