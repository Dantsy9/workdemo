package com.example.service.Impl;

import com.example.domain.Menu;
import com.example.domain.UserMenu;
import com.example.mapper.UserMenuMapper;
import com.example.service.PermsService;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@Service
public class PermsServiceImpl implements PermsService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Override
    public Long getType() {
        //获取request
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //转换成字符串
        String url = request.getRequestURI().toString();
        log.info("请求的url：{}", url);
        //获取请求头的token
        String jwt = request.getHeader("token");
        //解析token，转为map
        Claims claims = JwtUtils.parseJWT(jwt);
        //获取用户的type，用户权限类型，0是普通用户，1是管理员
        Long type = claims.get("type", Long.class);
        System.out.println(type);
        return type;
    }


}
