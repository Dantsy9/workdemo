package com.example.controller;

import com.example.domain.User;
import com.example.pojo.Result;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/path")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("员工登录：{}" , user);
        User u = loginService.login(user);
        if (u != null) {

            return Result.success(loginService.jwt(u));
        }
        return Result.error("登录失败，用户名或密码错误");
    }


//    public Result login(String userId , String deptId){
//        log.info("登录认证");
//        HashMap<String,Object> claims = new HashMap<>();
//        claims.put("id",userId);
//        claims.put("deptId",deptId);
//        String jwt = JwtUtils.generateJwt(claims);
//        return Result.success(jwt);
//    }
}
