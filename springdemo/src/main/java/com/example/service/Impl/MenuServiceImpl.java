package com.example.service.Impl;

import com.example.domain.Menu;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMenuMapper;
import com.example.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuTreeByUserId(Long userId) {
        List<Menu> menus;
        if(userId == 1){//从controller传来的type权限为管理员，则展示全部菜单
            menus = menuMapper.selectAll();
        }else{//通过menuid展示菜单
            Long[] menuId = userMenuMapper.selectMenuIdByUserId(userId);
            menus = menuMapper.selectMenuByMenuId(menuId);
        }
        return getMenuList(menus);
    }


    private List<Menu> getMenuList(List<Menu> menus) {

        List<Menu> parentMenu = new ArrayList<>();

        for (Menu menu : menus) {
            if(menu.getParentId().equals(0L)){
                findChildMenu(menu,menus);
                parentMenu.add(menu);
            }
        }
        return parentMenu;
    }

    private void findChildMenu(Menu parentMenu,List<Menu> menu){
        List<Menu> childrenMenu = new ArrayList<>();

        for (Menu menus : menu){
            if (parentMenu.getId().equals(menus.getParentId())){
                childrenMenu.add(menus);
            }
        }
        if(childrenMenu.isEmpty()){
            return;
        }
        parentMenu.setChildren(childrenMenu);

        for (Menu menus : childrenMenu){
            findChildMenu(menus,menu);
        }
    }


//    private List<Menu> buildMenuTree(List<Menu> menus){
//        List<Menu> menuTree = menus.stream()
//                .filter(menu -> menu.getParentId().equals(0L))
//                .map(menu -> menu.setChildren(getChildren(menus,menu.getId())))
//                .collect(Collectors.toList());
//    }
//
//    private List<Menu> getChildren(List<Menu> menus, Long menuId){
//        List<Menu> childrenList = menus.stream()
//                .filter(menu -> menu.getParentId().equals(menuId))
//                .collect(Collectors.toList());
//        return childrenList;
//    }



}
