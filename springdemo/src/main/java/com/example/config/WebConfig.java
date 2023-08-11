package com.example.config;

import com.example.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//当前类是配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor  loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器方法
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/path/login");//.excludePathPatterns("/path/login");//拦截/path/login


    }
}
