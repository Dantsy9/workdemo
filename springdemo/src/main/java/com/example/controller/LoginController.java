package com.example.controller;


import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/path")
public class LoginController {
    @PostMapping(value = "/login")
    public Result login(){
        log.info("登录认证");
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");
        String jwt = JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
