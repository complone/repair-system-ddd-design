package com.lizhi.guide.entity;

public class User {

    private Integer userId;

    private String userName;

    private Integer openater;// 1 编辑 2 删除 3 添加

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOpenater() {
        return openater;
    }

    public void setOpenater(Integer openater) {
        this.openater = openater;
    }
}
