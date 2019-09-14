package com.lizhi.guide.common.ResponseEnum;

/**
 * Created by complone on 2018/11/8.
 */
public enum ResponseCode {
    SUCCESS(0,"success"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_CHILD_NODE(3,"NOT EXITST CHILD NODE");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
