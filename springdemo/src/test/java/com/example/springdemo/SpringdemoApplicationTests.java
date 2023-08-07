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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


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
//        String resource = "config/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，来执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //TODO 断言


        //释放资源
//        sqlSession.close();
    }

    @Test
    void testAdd() {

        String name = "sclone";
        String tel = "25656";
        String password = "kamen";
        int age = 13;
        //封装对象
        User user = new User();
        user.setAge(age);

        user.setUsername(name);
        user.setTel(tel);
        user.setPassword(password);

        userMapper.add(user);
        Long idInfo = user.getId();
        System.out.println(idInfo);
    }

    @Test
    void testUpDate() {
        Long id = 10L;
        String username = "sclone";

        User user = new User();
        user.setId(id);
        user.setUsername(username);

        userMapper.update(user);
    }


    @Test
    void testDelById() {
        Long id = 10L;
        userMapper.delById(id);
    }

    @Test
    void testDelByIds() {
        Long[] ids = {9L, 10L};
        userMapper.delByIds(ids);
    }

    @Test
    void testSelectById() {
        Long id = 7L;
        List<User> selectById = userMapper.selectById(id);
        System.out.println(selectById);
    }


    @Test
    void testSelectByIdCondition() {
        Long id = 7L;
        //String name = "fv";

        HashMap map = new HashMap<>();
        map.put("id", id);
        //map.put("name",name);

        List<User> selectByCondition = userMapper.selectByCondition(map);

        System.out.println(selectByCondition);
    }

    @Test
    void testSelectMenuIdByUserId() {
        Long userId = 0L;
        Long[] menuId = userMenuMapper.selectMenuIdByUserId(userId);
    }

    @Test
    void testSelectAllmenu() {
        List<Menu> menuId = menuMapper.selectAll();
        System.out.println(Arrays.toString(menuId.toArray()));
    }


    @Test
    void testSelectMenuByMenuId() {
        Long[] menuId = {0L};
        List<Menu> menus = menuMapper.selectMenuByMenuId(menuId);
        System.out.println(Arrays.toString(menus.toArray()));
    }


//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testUpdate(){
    //tiao joan
//        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        lambdaUpdateWrapper.eq(User::getId,1L)
//                .set(User::getName,"Tom")
//                .set(User::getTel,"10086");
    //excute
//        int update = userMapper.update(null, lambdaUpdateWrapper);

    // assert
//        update ,1
//    }

}
