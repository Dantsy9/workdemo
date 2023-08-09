package com.example.controller;

import com.example.domain.Menu;
import com.example.domain.UserMenu;
import com.example.utils.Result;
import com.example.service.MenuService;
import com.example.service.PermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//TODO 类注释


/**
 * <p>
 * 获取用户菜单信息类
 * </p>
 * @author zmc
 * @since 2023/8/7
 */

@Slf4j
@RestController
public class UserGetInfoController {

    @Resource
    private PermsService permsService;

    @Resource
    private MenuService menuService;
    //TODO 方法注释
    /**
     *
     * @date: 2023/8/7
     * @param: 用户ID
     * @return: 用户菜单信息
     **/
    @PostMapping(value = "/getInfo")
    public Result getInfo(@RequestBody UserMenu id) {
        log.info("用户菜单信息获取请求");
        return menuService.getMenuTreeByUserId(id);
        //获取菜单列表
//        List<Menu> menuList = menuService.selectMenuTreeByUserId(userId);
//        return Result.success(menuList);
    }

    //TODO 分配权限的代码呢？
    //更改到Logincontroller
}