package com.example.service.Impl;

import com.example.domain.UserMenu;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMenuMapper;
import com.example.service.PermsService;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@Service
public class PermsServiceImpl implements PermsService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private MenuMapper menuMapper;


    /**
     * 查询用户的权限typeId
     * @date: 2023/8/8
     * @param: []
     * @return: typeId
     **/


    /**
     * 查询所有用户菜单关联表
     * @date: 2023/8/8
     * @param:
     * @return: 用户菜单关联表
     **/
    @Override
    public List<UserMenu> getAllUserPerms() {
        return userMenuMapper.getAllUserPerms();
    }



    /**
     * 批量增加用户权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 空信息，成功信息
     **/
    @Override
    public String addPerms(List<UserMenu> userMenus) {
        //先用传进来的数据和表的数据做对比，查看是否存在
        List<UserMenu> userMenus1 = getUserMenu(userMenus);
        //如果有查询到有相同的数据，则返回错误信息
        if (!userMenus1.isEmpty()){
            return null;
        }
        userMenuMapper.addUserPerms(userMenus);
        return "添加成功！";
    }

    /**
     * 批量删除用户权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 空信息，成功信息
     **/
    @Override
    public String delPerms(List<UserMenu> userMenus) {
        //先用传进来的数据和表的数据做对比，查看是否存在
        List<UserMenu> userMenus1 = getUserMenu(userMenus);
        //如果没有查询到有需要删除的数据，则返回错误信息
        if (userMenus1.isEmpty()){
            return null;
        }
        userMenuMapper.delUserPerms(userMenus);
        return "删除成功！";
    }

    /**
     * 批量多条件查询
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 查询到的数组对象
     **/
    @Override
    public List<UserMenu> getUserMenu(List<UserMenu> userMenus) {
        List<UserMenu> userMenus1 = userMenuMapper.getUserPerms(userMenus);
        return userMenus1;
    }


}
