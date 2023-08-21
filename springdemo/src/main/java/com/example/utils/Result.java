package com.example.utils;

import com.example.exception.DefinitionException;
import com.example.exception.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static Result success(){
        return new Result("1","success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result("1","success",data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result("0",msg,null);
    }
    //失败响应
    public static Result error(String msg , Object data){
        return new Result("0",msg,data);
    }

    public static Result error(String code , String msg){
        return new Result(code,msg,null);
    }
    //自定义异常返回响应
    public static Result error(ErrorEnum errorEnum){
        return new Result(errorEnum.getErrorCode(),errorEnum.getErrorMessage(),null);
    }
}