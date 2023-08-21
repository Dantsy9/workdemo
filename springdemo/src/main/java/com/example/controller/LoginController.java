package com.example.controller;

import com.example.annn.Log;
import com.example.domain.User;
import com.example.domain.UserMenu;
import com.example.exception.DefinitionException;
import com.example.exception.ErrorEnum;
import com.example.utils.Result;
import com.example.service.LoginService;
import com.example.service.PermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 登录验证类
 * </p>
 * @author zmc
 * @since 2023/8/7
 */
@Slf4j
@RestController
@RequestMapping("/path")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private PermsService permsService;

    /**
     * 获取登录信息并验证，成功返回token
     * @date: 2023/8/7
     * @param: [user]
     * @return: 返回token
     **/
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录：{}" , user);
        String u = loginService.login(user);
        if (u == null) {
            throw new DefinitionException(ErrorEnum.USER_NOT_MATCH);
        }
        return Result.success(u);
    }


    /**
     * 增加用户权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 成功信息
     **/
    @PostMapping("/addPerms")
//    @Log
    public Result addPerms(@RequestBody List<UserMenu> userMenus){
        log.info("用户权限变更，增加用户权限");
        Boolean result = permsService.addPerms(userMenus);
        if (!result){
            throw new DefinitionException(ErrorEnum.USER_PERMS_EXIST);
        }
        return Result.success();
    }

    /**
     *
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 成功信息
     **/
    @DeleteMapping("/delPerms")
//    @Log
    public Result delPerms(@RequestBody List<UserMenu> userMenus){
        log.info("用户权限变更，删除用户权限");
        String resultInfo = permsService.delPerms(userMenus);
        if (resultInfo == null){
            throw new DefinitionException(ErrorEnum.USER_PERMS_NOT_EXIST);
        }
        return Result.success(resultInfo);
    }

}
