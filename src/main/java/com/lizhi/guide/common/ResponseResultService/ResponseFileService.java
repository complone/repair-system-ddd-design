package com.lizhi.guide.common.ResponseResultService;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseFileService<T> implements Serializable {

    private Integer success; //0 | 1 ,//0表示上传失败;1表示上传成功

    private String message; //提示的信息

    private String url; //图片地址，上传成功才返回

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResponseFileService(Integer success, String message, String url) {
        this.success = success;
        this.message = message;
        this.url = url;
    }

    public ResponseFileService(Integer success,String message){
        this.success = success;
        this.message = message;
    }

    public ResponseFileService(String message){
        this.message = message;
    }

    public static<T> ResponseFileService<T> createBySuccess(String message,String url){
        return new  ResponseFileService<T>(1,message,url);
    }

    public static<T> ResponseFileService<T> createByError(String message,String url){
        return new  ResponseFileService<T>(0,message,url);
    }

    public static<T> ResponseFileService<T> createMDBySuccess(String message){
        return new  ResponseFileService<T>(1,message);
    }

    public static<T> ResponseFileService<T> createMDByError(String message){
        return new  ResponseFileService<T>(0,message);
    }

    public static<T> ResponseFileService<T> createMDBySuccess(String message,String url){
        return new  ResponseFileService<T>(1,message,url);
    }

    public static<T> ResponseFileService<T> createMDByError(String message,String url){
        return new  ResponseFileService<T>(1,message,url);
    }



}
