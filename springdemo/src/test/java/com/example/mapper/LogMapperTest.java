package com.example.mapper;

import com.example.domain.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@Slf4j
class LogMapperTest {

    @Resource
    private LogMapper logMapper;

    @Test
    void testSave(){
        Log log = new Log();
        log.setId(2L);
        log.setOperator("MC");
        log.setObject("userId=1,menuId=0");
        log.setConsequence("0");
        log.setMethod("0");
        logMapper.insert(log);
    }

    @Test
    void testDel(){

    }

    @Test
    @Transactional
    void insertInfo() {
        Log log = new Log();
        log.setOperator("MC");
        log.setObject("231");
        log.setConsequence("321");
        log.setMethod("test");
        int result = logMapper.insertInfo(log);
        Assertions.assertEquals(1,result);
    }
}