package com.example.mapper;

import com.example.domain.UserMenu;
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

class UserMenuMapperTest {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Test
    void getMenuIdByUserId() {
        Long id = 1L;
        Long[] result = userMenuMapper.getMenuIdByUserId(id);
        Assertions.assertNotNull(result);
    }

    @Test
    void getAllUserPerms() {
        List<UserMenu> result = userMenuMapper.getAllUserPerms();
        System.out.println(result);
    }


    @Test
    @Transactional
    void addUserPerms() {
        UserMenu userMenu1 = new UserMenu();
        UserMenu userMenu2 = new UserMenu();
        userMenu1.setUserId(2L);
        userMenu1.setMenuId(20L);
        userMenu2.setUserId(3L);
        userMenu2.setMenuId(30L);
        List<UserMenu> userMenus = new ArrayList<>();
        userMenus.add(userMenu1);
        userMenus.add(userMenu2);
        boolean result = userMenuMapper.addUserPerms(userMenus);
        Assertions.assertTrue(result);
    }

    @Test
    @Transactional
    void delUserPerms() {
        UserMenu userMenu1 = new UserMenu();
        UserMenu userMenu2 = new UserMenu();
        userMenu1.setUserId(2L);
        userMenu1.setMenuId(20L);
        userMenu2.setUserId(3L);
        userMenu2.setMenuId(30L);
        List<UserMenu> userMenus = new ArrayList<>();
        userMenus.add(userMenu1);
        userMenus.add(userMenu2);
        boolean result = userMenuMapper.delUserPerms(userMenus);
        Assertions.assertFalse(result);
    }

    @Test
    void getUserPerms() {
        UserMenu userMenu1 = new UserMenu();
        UserMenu userMenu2 = new UserMenu();
        userMenu1.setUserId(2L);
        userMenu1.setMenuId(20L);
        userMenu2.setUserId(3L);
        userMenu2.setMenuId(30L);
        List<UserMenu> userMenus = new ArrayList<>();
        userMenus.add(userMenu1);
        userMenus.add(userMenu2);
        List<UserMenu> result = userMenuMapper.getUserPerms(userMenus);
        assert result.isEmpty();
    }
}