package com.example.service.Impl;


import com.example.domain.MenuDTO;

import com.example.exception.DefinitionException;
import com.example.exception.ErrorEnum;
import com.example.mapper.MenuMapper;

import com.example.mapper.UserMenuMapper;
import com.example.service.MenuService;

import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private MenuMapper menuMapper;



    @Override
    public  List<MenuDTO> getMenuTreeByUserId(//TODO 使用合适的数据类型
                                               Long id) {
        //TODO
        Long[] menuId = userMenuMapper.getMenuIdByUserId(id);
        //TODO 这样写会有什么问题？
        if (menuId.length==0){
            throw new DefinitionException(ErrorEnum.USER_PERMS_NOT_EXIST);
        }
        //TODO 常量怎么定义？
        final Long menuIdSpecial = 0L;
        //TODO 这个变量的作用？
        //标识是否存在menuIdSpecial
        boolean isMenuIdSpecial = false;
        //遍历menu数组，查找menuId是否为0，是则展示全部菜单
        for(Long number : menuId){
            if (Objects.equals(number, menuIdSpecial)){
                isMenuIdSpecial = true;
                break;
            }
        }
        List<MenuDTO> menus;
        if(isMenuIdSpecial){
            menus = menuMapper.selectAll();
        }else{
            //通过menuId获取对应菜单
            menus = menuMapper.selectMenuByMenuId(menuId);
        }
        return getMenuList(menus);
    }

    /**
     * 获得树级结构菜单
     * @date: 2023/8/9
     * @param: 用户菜单
     * @return: 菜单排序结果
     **/
    private List<MenuDTO> getMenuList(List<MenuDTO> menus) {

        //TODO 换一个方式

        //存储根节点的菜单，即父级菜单
        List<MenuDTO> parentMenu = new ArrayList<>();
        //遍历所有数据，找到根节点菜单
        for (MenuDTO menuDTO : menus) {
            if(menuDTO.getParentId().equals(0L)){
                //找到根节点菜单的时候，寻找并设置这个根节点菜单下的子节点菜单。
                setChildMenu(menuDTO, menus);
                //添加到根节点的列表中
                parentMenu.add(menuDTO);
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
    private void setChildMenu(
            //TODO 命名
            MenuDTO menuDTO,List<MenuDTO> menus){
        //存储根节点的菜单，即子级菜单
        List<MenuDTO> childrenMenu = new ArrayList<>();
        //遍历所有数据，找到是入参父节点的子节点的数据，然后加到childrenMenu集合中。
        for (MenuDTO temp : menus){
            if (menuDTO.getId().equals(temp.getParentId())){
                childrenMenu.add(temp);
            }
        }
//        return childrenMenu;
//        如果子节点不存在，则不必再遍历子节点中的子节点了 直接返回。
        if(childrenMenu.isEmpty()){
            return;
        }
//        设置父节点的子节点列表
        menuDTO.setChildrenList(childrenMenu);
//        若子节点存在，接着递归调用该方法，寻找子节点的子节点
        for (MenuDTO temp : childrenMenu){
            setChildMenu(temp,menus);
        }
    }

}
