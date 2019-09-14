package com.lizhi.guide.exception;

import com.lizhi.guide.common.ResponseEnum.ResponseExceptionCode;
import com.lizhi.guide.entity.Document;


public class DocumentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;  //错误码

    private String msg;


    public DocumentException(ResponseExceptionCode resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }


    public DocumentException(String errorMessage){
        this.msg = errorMessage;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
