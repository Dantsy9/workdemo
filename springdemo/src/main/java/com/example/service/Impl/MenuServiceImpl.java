package com.example.service.Impl;

import com.example.domain.Menu;
import com.example.domain.MenuDTO;
import com.example.domain.UserMenu;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMapper;
import com.example.mapper.UserMenuMapper;
import com.example.service.MenuService;
import com.example.utils.Result;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
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

    @Resource
    private UserMapper userMapper;


    @Override
    public Result getMenuTreeByUserId(UserMenu id) {
        //获取用户user_id
        Long userId = id.getUserId();
        Long typeId = userMapper.getTypeIdById(userId);
        List<Menu> menus;
        if(typeId == 0){
            //如果type为0，则为管理员，展示全部菜单
            menus = menuMapper.selectAll();
        }else{
            //通过userId获取菜单menuId
            Long[] menuId = userMenuMapper.getMenuIdByUserId(userId);
            //通过menuId获取对应菜单
            menus = menuMapper.selectMenuByMenuId(menuId);
        }
        return Result.success(getMenuList(menus));
    }

    /**
     * 获得树级结构菜单
     * @date: 2023/8/9
     * @param: 用户菜单
     * @return: 菜单排序结果
     **/
    private List<MenuDTO> getMenuList(List<Menu> menus) {
        //使用orika复制工具将menus集合复制到menuDTOS集合中
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        List<MenuDTO> menuDTOS = mapperFactory.getMapperFacade().mapAsList(menus,MenuDTO.class);
        //存储根节点的菜单，即父级菜单
        List<MenuDTO> parentMenu = new ArrayList<>();
        //遍历所有数据，找到根节点菜单
        for (MenuDTO menuDTO1 : menuDTOS) {
            if(menuDTO1.getParentId().equals(0L)){
                //找到根节点菜单的时候，寻找这个根节点菜单下的子节点菜单。
                findChildMenu(menuDTO1,menuDTOS);
                //添加到根节点的列表中
                parentMenu.add(menuDTO1);
            }
        }
        return parentMenu;
    }
    /**
     * 查找并创建子菜单
     * @date: 2023/8/8
     * @param: 父菜单
     * @return: void
     **/
    private void findChildMenu(MenuDTO parentMenu,List<MenuDTO> menuDTOS){
        //存储根节点的菜单，即子级菜单
        List<MenuDTO> childrenMenu = new ArrayList<>();
        //遍历所有数据，找到是入参父节点的子节点的数据，然后加到childrenMenu集合中。
        for (MenuDTO MenuDTOS : menuDTOS){
            if (parentMenu.getId().equals(MenuDTOS.getParentId())){
                childrenMenu.add(MenuDTOS);
            }
        }
        //如果子节点不存在，则不必再遍历子节点中的子节点了 直接返回。
        if(childrenMenu.isEmpty()){
            return;
        }
        //设置父节点的子节点列表
        parentMenu.setChildrenList(childrenMenu);
        //若子节点存在，接着递归调用该方法，寻找子节点的子节点
        for (MenuDTO MenuDTOS : childrenMenu){
            findChildMenu(MenuDTOS,menuDTOS);
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
