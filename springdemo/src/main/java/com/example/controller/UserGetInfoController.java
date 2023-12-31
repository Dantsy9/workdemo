package com.example.controller;

import com.example.domain.MenuDTO;
import com.example.domain.UserMenu;
import com.example.exception.DefinitionException;
import com.example.exception.ErrorEnum;
import com.example.utils.Result;
import com.example.service.MenuService;
import com.example.service.PermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 类注释


/**
 * <p>
 * 获取用户菜单信息类
 * </p>
 * @author zmc
 * @since 2023/8/7
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserGetInfoController {


    @Resource
    private MenuService menuService;
    // 方法注释
    /**
     *
     * @date: 2023/8/7
     * @param: 用户ID
     * @return: 用户菜单信息
     **/
    @GetMapping(value = "/getMenu")
    public Result getInfo(Long id) {
        log.info("用户菜单信息获取请求");
        return Result.success(menuService.getMenuTreeByUserId(id));
        //获取菜单列表
//        List<Menu> menuList = menuService.selectMenuTreeByUserId(userId);
//        return Result.success(menuList);
    }


}