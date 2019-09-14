package com.lizhi.guide.entity;

import java.util.Date;

public class Team {

    private Integer teamId;

    private String teamName;

    private Date createTime;

    private Date updateTime;

    public Team(Integer teamId, String teamName, Date createTime, Date updateTime) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Team(){
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
