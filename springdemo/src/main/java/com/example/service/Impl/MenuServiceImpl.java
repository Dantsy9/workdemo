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
import java.util.Objects;


@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private MenuMapper menuMapper;



    @Override
    public Result getMenuTreeByUserId(UserMenu id) {
        //获取用户user_id
        Long userId = id.getUserId();
        Long[] menuId = userMenuMapper.getMenuIdByUserId(userId);
        Long menuIdSpecial = 0L;
        boolean isMenuIdSpecial = false;
        //遍历menu数组，查找menuId是否为0，是则展示全部菜单
        for(Long number  : menuId){
            if (Objects.equals(number, menuIdSpecial)){
                isMenuIdSpecial = true;
                break;
            }
        }
        List<Menu> menus;
        if(isMenuIdSpecial){
            //TODO 确认好需求后在决定要不要写，做好沟通
            menus = menuMapper.selectAll();
        }else{
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
                //找到根节点菜单的时候，寻找并设置这个根节点菜单下的子节点菜单。
                //TODO 方法名和方法做的事情不一致
                setChildMenu(menuDTO1, menuDTOS);
//                menuDTO1.setChildrenList(childMenu);
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
    private void setChildMenu(MenuDTO menuDTO1,List<MenuDTO> menuDTOS){
        //存储根节点的菜单，即子级菜单
        List<MenuDTO> childrenMenu = new ArrayList<>();
        //遍历所有数据，找到是入参父节点的子节点的数据，然后加到childrenMenu集合中。
        for (MenuDTO MenuDTOS : menuDTOS){
            if (menuDTO1.getId().equals(MenuDTOS.getParentId())){
                childrenMenu.add(MenuDTOS);
            }
        }
//        return childrenMenu;
//        如果子节点不存在，则不必再遍历子节点中的子节点了 直接返回。
        if(childrenMenu.isEmpty()){
            return;
        }
//        设置父节点的子节点列表
        menuDTO1.setChildrenList(childrenMenu);
//        若子节点存在，接着递归调用该方法，寻找子节点的子节点
        for (MenuDTO MenuDTOS : childrenMenu){
            setChildMenu(MenuDTOS,menuDTOS);
        }
    }

}
