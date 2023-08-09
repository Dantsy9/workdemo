package com.example.mapper;

import com.example.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getTypeIdById() {
        Long userId = 1L;
        Long userId1 = 3L;
        Long typeId = userMapper.getTypeIdById(userId);
        Long typeId1 = userMapper.getTypeIdById(userId1);
        assert typeId == 0 && typeId1 == null;
    }

    @Test
    void add() {
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        user.setTel("10010");
        user.setAge(10);
        boolean result = userMapper.add(user);
        Assertions.assertTrue(result);
    }

    @Test
    //@Transactional//该注解能防止测试污染数据库内数据信息
    void update() {
        User user = new User();
        user.setUsername("Tom");
        user.setAge(23);
        int result = userMapper.update(user);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    @Transactional
    void delById() {
        Long id = 3L;
        boolean result =  userMapper.delById(id);
        Assertions.assertTrue(result);
    }

    @Test
    @Transactional
    void delByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        boolean result = userMapper.delByIds(ids);
        assert result;
    }

    @Test
    void selectAll() {
        List<User> users = userMapper.selectAll();
        assert users != null;
    }

    @Test
    void selectById() {
        Long id = 1L;
        List<User> user = userMapper.selectById(id);
        Assertions.assertNotNull(user);
    }

    @Test
    void selectByCondition() {
        User user = new User();
        user.setId(1L);
        List<User> reslut = userMapper.selectByCondition(user);
        Assertions.assertNotNull(reslut);
    }

    @Test
    void getByNameAndPassword() {
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("321");
        User result = userMapper.getByNameAndPassword(user);
        Assertions.assertNull(result);
    }
}