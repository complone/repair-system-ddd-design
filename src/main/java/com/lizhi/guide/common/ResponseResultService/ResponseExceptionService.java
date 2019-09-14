package com.lizhi.guide.common.ResponseResultService;

import com.lizhi.guide.common.ResponseEnum.ResponseExceptionCode;

import java.io.Serializable;

public class ResponseExceptionService<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    private ResponseExceptionService(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    private ResponseExceptionService(T data){
        this.code = ResponseExceptionCode.SUCCESS.getCode();
        this.message = ResponseExceptionCode.SUCCESS.getMsg();
        this.data = data;
    }

    private Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    private String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }



    public static<T> ResponseExceptionService<T> error(Integer code,String message){
        return new  ResponseExceptionService<T>(code,message);
    }


}
