package com.example.config;

import com.example.exception.DefinitionException;
import com.example.exception.ErrorEnum;
import com.example.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Enumeration;

/**
 * <p>
 * 全局异常处理器
 * </p>
 *
 * @author zmc
 * @since 2023-08-17
 */

@RestControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 处理自定义异常并返回统一格式
     * @date: 2023/8/17
     * @param: 自定义异常
     * @return: 错误信息和统一返回格式
     **/
    @ExceptionHandler(DefinitionException.class)
    public Result definitionExceptionHandle(DefinitionException ex){

        return Result.error(ex.getErrorCode(),ex.getErrorMsg());

    }
    /**
     * 处理其他异常并返回统一格式
     * @date: 2023/8/17
     * @param: 其他异常
     * @return: 错误信息和统一返回格式
     **/
//    @ExceptionHandler(Exception.class)
//    public Result servletExceptionHandle(Exception e){
//
//        return Result.error(ErrorEnum.INTERNAL_SERVER_ERROR);
//
//    }
}
