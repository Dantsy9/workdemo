package com.example.controller;

import com.example.domain.Menu;
import com.example.pojo.Result;
import com.example.service.MenuService;
import com.example.service.PermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//TODO 类注释
@Slf4j
@RestController
public class UserGetInfoController {

    @Resource
    private PermsService permsService;

    @Resource
    private MenuService menuService;
    //TODO 方法注释
    @PostMapping(value = "/getinfo")
    public Result getInfo() {
        log.info("用户信息获取请求");
        //获取用户权限类型Type
        Long typeId = permsService.getType();
        //获取菜单列表
        List<Menu> menuList = menuService.selectMenuTreeByUserId(typeId);
        //封装

        return Result.success(menuList);
    }

    //TODO 分配权限的代码呢？
}