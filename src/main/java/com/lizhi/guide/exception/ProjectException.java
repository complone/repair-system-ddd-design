package com.lizhi.guide.exception;

import com.lizhi.guide.common.ResponseEnum.ResponseExceptionCode;

public class ProjectException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;  //错误码

    private String msg;



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ProjectException() {}



    public ProjectException(ResponseExceptionCode resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public ProjectException(String errorMessage){
        this.msg = errorMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
