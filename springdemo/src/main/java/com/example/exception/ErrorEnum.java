package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *  自定义错误枚举
 * </p>
 *
 * @author zmc
 * @Since 2023-08-17
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {
    // 数据操作错误定义
    TOKEN_NOT_MATCH("4001","TOKEN不匹配!"),
    USER_NOT_MATCH("4004", "用户名或密码错误!"),
    USER_PERMS_EXIST("4005", "用户权限已存在!"),
    USER_PERMS_NOT_EXIST("4006","用户权限不存在!"),
    INTERNAL_SERVER_ERROR("5000","服务器内部出错!");

    //错误code
    private final String errorCode;
    //错误信息
    private final String errorMessage;


}
