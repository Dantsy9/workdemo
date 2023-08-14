package com.example.service;


import com.example.domain.Menu;
import com.example.domain.User;
import com.example.domain.UserMenu;
import com.example.utils.Result;

import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 * 权限服务类
 * </p>
 * @author zmc
 * @since 2023/8/8
 */
public interface PermsService {


    /**
     * 获取所有用户菜单关联表
     * @date: 2023/8/8
     * @param:
     * @return: 用户菜单关联表
     **/
    List<UserMenu> getAllUserPerms();

    /**
     * 新增用户菜单权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: void
     **/
    Result addPerms(List<UserMenu> userMenus);


    /**
     * 管理员删除用户菜单权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: void
     **/
    String delPerms(List<UserMenu> userMenus);

    /**
     * 批量查询用户菜单关联表
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 查询结果的List
     **/
    List<UserMenu> getUserMenuByUserMenu(List<UserMenu> userMenus);
}
