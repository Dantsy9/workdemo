package com.example.service.Impl;

import com.example.domain.Addlog;
import com.example.mapper.AddlogMapper;
import com.example.service.LogStatsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class LogStatsServiceImplTest {

    @Resource
    private LogStatsService logStatsService;

//    @Test
//    void operatorStats() {
//        Object object = logStatsService.operatorStats();
//        String objectString = object.toString();
//        System.out.println(objectString);
//        assert !objectString.isEmpty();
//    }
}