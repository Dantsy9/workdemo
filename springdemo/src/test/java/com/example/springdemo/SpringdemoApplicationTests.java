package com.example.springdemo;

import com.example.domain.Menu;
import com.example.domain.User;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMapper;
import com.example.mapper.UserMenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;


@SpringBootTest
@MapperScan("com.example.mapper")
class SpringdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private MenuMapper menuMapper;


    @Test
    void testSelectAll() {

        List<User> users = userMapper.selectAll();
        assert users != null;
        //TODO 断言
    }
    //全部重写一次

}
