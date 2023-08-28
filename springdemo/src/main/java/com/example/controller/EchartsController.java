package com.example.controller;

import com.example.domain.AddlogDTO;
import com.example.service.LogStatsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  图表统计 控制层
 * </p>
 *
 * @author zmc
 * @since 2023-08-21
 */

@Slf4j
@RestController
public class EchartsController {

    @Resource
    private LogStatsService logStatsService;

    /**
     * 请求统计数据
     * @date: 2023/8/28
     * @param:
     * @return: 统计数据集合
     **/
    @GetMapping("/getAddLogStats")
    public List<AddlogDTO> getAddLogStats(){
        return logStatsService.operatorStats();
    }
}
