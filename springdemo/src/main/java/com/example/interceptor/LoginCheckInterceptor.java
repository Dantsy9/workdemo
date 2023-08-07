package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override  //目标方法执行前执行，返回ture，放行；反之不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object handler) throws Exception {
        //        - 获取请求的url
        String url = req.getRequestURI().toString(); //转换成字符串
        log.info("请求的url：{}" , url);
//                - 判断请求中是否包含login，如果包含，就说明是登录操作，放行
        //TODO 拦截器中还需要这个步骤吗？
        if(url.contains("login")){
            log.info("登录操作，放行");
            return true;
        }
//                - 获取请求头中的令牌(token)
        String jwt = req.getHeader("token");
//                - 判断令牌是否存在，如果不存在返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){ //查询字符串是否有长度
            log.info("请求头为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin =  JSONObject.toJSONString(error);//通过JSON这个方法将json转为string
            rep.getWriter().write(notLogin);
            return false;
        }
//        - 解析token，如果解析失败，返回错误结果（未登录）
        try {
            Claims claims = JwtUtils.parseJWT(jwt);

            //TODO 本地调试结束后，所有system.out代码要删掉
            System.out.println(claims);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin =  JSONObject.toJSONString(error);//通过JSON这个方法将json转为String
            System.out.println(notLogin);
            rep.getWriter().write(notLogin);
            return false;
        }
//        - 都成功，放行。
        log.info("身份验证成功");
        return true;
    }

    @Override  //目标方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle......");
    }

    @Override  //视图渲染完成后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion......");
    }
}
