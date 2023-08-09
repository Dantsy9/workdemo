package com.example.service.Impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.LoginService;
import com.example.utils.JwtUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;


    @Override
    public String login(User user) {
        //到数据库中对比用户名和密码来验证是否正确
        User u = userMapper.getByNameAndPassword(user);
        if (u == null) {
            return null;
        }
        //直接返回token，调用jwt方法生成
        return jwt(u);
    }

    @Override
    public String jwt(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("password", user.getPassword());
        claims.put("type", user.getType());

        String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的用户信息
        return jwt;
    }

}
