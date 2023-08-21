package com.example.exception;


/**
 * <p>
 *  自定义异常处理类
 * </p>
 *
 * @author zmc
 * @Since 2023-08-17
 */


public class DefinitionException extends RuntimeException{
    //错误code
    protected String errorCode;
    //错误信息
    protected String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DefinitionException(){
        super();
    }

    public DefinitionException(ErrorEnum errorEnum){
        super(errorEnum.getErrorCode());
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMessage();
    }

    public DefinitionException(ErrorEnum errorEnum,Throwable cause){
        super(errorEnum.getErrorCode(),cause);
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMessage();
    }

    public DefinitionException(String errorMsg){
        super(errorMsg);
        this.errorMsg=errorMsg;
    }
    public DefinitionException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public DefinitionException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }



}
