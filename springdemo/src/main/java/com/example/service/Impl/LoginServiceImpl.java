package com.example.service.Impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.LoginService;
import com.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getByNameAndPassword(user);
    }

    @Override
    public String jwt(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("password", user.getPassword());
        claims.put("type", user.getType());

        String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
        return jwt;
    }

}
