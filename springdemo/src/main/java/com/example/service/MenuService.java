package com.example.service;


import com.example.domain.UserMenu;
import com.example.utils.Result;

/**
 * <p>
 * 菜单接口
 * </p>
 * @author zmc
 * @since 2023/8/7
 */
public interface MenuService {
    /**
     * 通过用户id获取菜单列表建立菜单树
     * @date: 2023/8/9
     * @param: user_id
     * @return: 菜单树
     **/
    Result getMenuTreeByUserId(UserMenu id);






}
