package com.example.mapper;

import com.example.domain.Addlog;
import com.example.domain.AddlogDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class AddlogMapperTest {

    @Resource
    private AddlogMapper addlogMapper;

    @Test
    void testGetMethodAndOperationTime(){
        List<AddlogDTO> methodAndOperationTime = addlogMapper.getCountMethodAndOperationTimeByMethod("addPerms");
        Assertions.assertNotNull(methodAndOperationTime);
        System.out.println(methodAndOperationTime);
    }

    @Test
    void selectAll(){
        List<Addlog> addlogs = addlogMapper.selectList(null);
        Assertions.assertNotNull(addlogs);
        System.out.println(addlogs);
    }

    @Test
    void selectMethod(){
        List<String> method = addlogMapper.selectMethod();
        Assertions.assertNotNull(method);
    }

}