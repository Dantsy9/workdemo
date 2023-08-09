package com.example.mapper;

import com.example.domain.Menu;
import com.example.domain.UserMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMenuMapper {

    //通过用户id查询对应展示的menuid，其中，如果用户为管理员则menuid=0，默认展示全部菜单id
    @Select("select menu_id from user_menu where user_id = #{user_id}")
    Long[] getMenuIdByUserId(Long userId);

    //获得角色菜单关联表全部信息
    @Select("select * from user_menu")
    List<UserMenu> getAllUserPerms();

    //批量增加用户权限
    boolean addUserPerms(List<UserMenu> userMenus);

    //批量删除用户权限
    boolean delUserPerms(List<UserMenu> userMenus);

    //批量查询用户是否存在菜单权限
    List<UserMenu> getUserPerms(List<UserMenu> userMenus);
}
