package com.example.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Log;
import com.example.mapper.LogMapper;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 * log切面类
 * </p>
 *
 * @author zmc
 * @since 2023-08-10
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    @Resource
    private HttpServletRequest request;

    @Resource
    private LogMapper logMapper;

    @Around("@annotation(com.example.annn.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人id - userId
        //获取token，解析到username
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        String operator = (String) claims.get("username");

        //操作时间
        LocalDateTime operationTime = LocalDateTime.now();

        //操作类型（方法名）
        String methodName = joinPoint.getSignature().getName();

        //操作对象
        Object[] objects = joinPoint.getArgs();
        String object = Arrays.toString(objects);

        //调用目标方法运行
        Object result = joinPoint.proceed();

        //操作结果,return
        String consequence = JSONObject.toJSONString(result);


        //记录操作日志，调用insertInfo
        Log logs = new Log();
        logs.setOperator(operator);
        logs.setOperationTime(operationTime);
        logs.setMethod(methodName);
        logs.setObject(object);
        logs.setConsequence(consequence);
        logMapper.insert(logs);
        log.info("AOP操作日志记录：{}",logs);
        return result;
    }

}
