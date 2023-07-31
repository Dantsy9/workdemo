package com.example.Filter;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest; //对请求进行强转
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        //        - 获取请求的url
        String url = req.getRequestURI().toString(); //转换成字符串
        log.info("请求的url：" , url);
//                - 判断请求中是否包含login，如果包含，就说明是登录操作，放行
        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
        }
//                - 获取请求头中的令牌(token)
        String jwt = req.getHeader("token");
//                - 判断令牌是否存在，如果不存在返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){ //查询字符串是否有长度
            log.info("请求头为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin =  JSONObject.toJSONString(error);//通过JSON这个方法将string转为json
            rep.getWriter().write(notLogin);
            return;
        }

//        - 解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin =  JSONObject.toJSONString(error);//通过JSON这个方法将string转为json
            rep.getWriter().write(notLogin);
            return;
        }
//        - 都成功，放行。
        log.info("登录成功");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
