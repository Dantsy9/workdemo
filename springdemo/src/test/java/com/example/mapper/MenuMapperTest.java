package com.example.mapper;

import com.example.domain.Menu;
import com.example.domain.MenuDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@Slf4j
class MenuMapperTest {

    @Resource
    private MenuMapper menuMapper;

    @Test
    void selectAll() {
        List<MenuDTO> menus = menuMapper.selectAll();
        Assertions.assertNotNull(menus);
    }

    @Test
    void selectMenuByMenuId() {
        Long[] ids = new Long[]{1L};
        List<MenuDTO> result = menuMapper.selectMenuByMenuId(ids);
        Assertions.assertNotNull(result);
    }

    @Test
    void selectMenuNameByMenuId() {
        Long[] ids = new Long[]{1L,2L,3L};
        List<MenuDTO> result = menuMapper.selectMenuByMenuId(ids);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}