package com.example.controller;

import com.example.domain.User;
import com.example.domain.UserMenu;
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
        log.info("员工登录：{}" , user);
        String u = loginService.login(user);
        if (u != null) {
            //TODO 不能在login方法中返回吗？
            return Result.success(u);
        }
        return Result.error("登录失败，用户名或密码错误");
    }


    /**
     * 增加用户权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 成功信息
     **/
    @PostMapping("/addPerms")
    public Result addPerms(@RequestBody List<UserMenu> userMenus){
        log.info("用户权限变更，增加用户权限");
        String resultInfo = permsService.addPerms(userMenus);
        if (resultInfo == null){
            return Result.error("失败，用户已存在部分权限");
        }
        return Result.success(resultInfo);
    }

    /**
     *
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 成功信息
     **/
    @DeleteMapping("/delPerms")
    public Result delPerms(@RequestBody List<UserMenu> userMenus){
        log.info("用户权限变更，删除用户权限");
        String resultInfo = permsService.delPerms(userMenus);
        if (resultInfo == null){
            return Result.error("失败，用户不存在对应权限");
        }
        return Result.success(resultInfo);
    }



    /**
     * 查询用户是否存在或用户是否拥有目标权限
     * @date: 2023/8/8
     * @param: List数组对象用户菜单关联表
     * @return: 查询结果
     **/
//    @PostMapping("/selectPerms")
//    public Result selectPerms(@RequestBody List<UserMenu> userMenus){
//        log.info("查询用户是否存在权限");
//        List<UserMenu> userMenus1 = permsService.getUserMenu(userMenus);
//        if(userMenus1.isEmpty()){
//            return Result.error("查询失败！请确认用户是否存在或用户是否拥有目标权限");
//        }
//        return Result.success(userMenus1);
//    }
//
}
