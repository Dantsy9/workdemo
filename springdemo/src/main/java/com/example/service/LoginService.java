package com.example.service;


import com.example.domain.User;


public interface LoginService {
    //TODO 用文档注释 不用行注释，行注释使用时要写在代码上方
    User login(User user);//验证登录
    //获取秘钥
    String jwt(User user);





}
