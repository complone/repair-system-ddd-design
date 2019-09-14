package com.lizhi.guide.common.ResponseEnum;

public enum  ResponseExceptionCode {


    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    ;

    private Integer code;

    private String msg;

    ResponseExceptionCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}
