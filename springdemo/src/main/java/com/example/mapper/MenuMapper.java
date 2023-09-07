package com.example.mapper;

import com.example.domain.Menu;
import com.example.domain.MenuDTO;


import java.util.List;


public interface MenuMapper {
    //展示全部菜单
    List<MenuDTO> selectAll();
    //按照menuId展示
    List<MenuDTO> selectMenuByMenuId(Long[] menuId);

    List<MenuDTO> selectMenuNameByMenuId(Long[] menuId);
}
