package com.example.service;


import com.example.domain.User;


public interface LoginService {

    User login(User user);//验证登录

    String jwt(User user);//获取秘钥





}
