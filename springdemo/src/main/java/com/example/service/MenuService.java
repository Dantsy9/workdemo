package com.example.service;


import com.example.domain.Menu;

import java.util.List;

public interface MenuService {
    //通过id建立菜单树
    List<Menu> selectMenuTreeByUserId(Long userId);




}
