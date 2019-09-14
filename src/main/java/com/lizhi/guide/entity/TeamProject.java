package com.lizhi.guide.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.swing.plaf.ComponentInputMapUIResource;
import java.util.Date;

public class TeamProject implements Comparable<TeamProject> {


    private Long teamProjectId; //teamProject ID 有可能是 64 位的。虽然自己的应用不一定能增长到超过 32 位，
                               // 但是teamProject很可能是 64 位的

    private Integer teamId; //所归属上一级部门id

    private String teamProjectName; // 项目名

    private String teamProjectCharge;//项目负责人

    private String teamProjectDescrption;//项目描述

    private String teamProjectAddress;

    private Date createTime; // 创建时间

    private Date updateTime; // 更新时间


    public TeamProject(Long teamProjectId, Integer teamId, String teamProjectName, String teamProjectCharge, String teamProjectDescrption,
                       String teamProjectAddress, Date createTime, Date updateTime) {
        this.teamProjectId = teamProjectId;
        this.teamId = teamId;
        this.teamProjectName = teamProjectName;
        this.teamProjectCharge = teamProjectCharge;
        this.teamProjectDescrption = teamProjectDescrption;
        this.teamProjectAddress = teamProjectAddress;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getTeamProjectAddress() {
        return teamProjectAddress;
    }

    public void setTeamProjectAddress(String teamProjectAddress) {
        this.teamProjectAddress = teamProjectAddress;
    }

    public TeamProject(){
        super();
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



    public Long getTeamProjectId() {
        return teamProjectId;
    }

    public void setTeamProjectId(Long teamProjectId) {
        this.teamProjectId = teamProjectId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamProjectName() {
        return teamProjectName;
    }

    public void setTeamProjectName(String teamProjectName) {
        this.teamProjectName = teamProjectName;
    }

    public String getTeamProjectCharge() {
        return teamProjectCharge;
    }

    public void setTeamProjectCharge(String teamProjectCharge) {
        this.teamProjectCharge = teamProjectCharge;
    }

    public String getTeamProjectDescrption() {
        return teamProjectDescrption;
    }

    public void setTeamProjectDescrption(String teamProjectDescrption) {
        this.teamProjectDescrption = teamProjectDescrption;
    }

    @Override
    public int compareTo(TeamProject o) {
        return teamProjectId.compareTo(o.getTeamProjectId());
    }
}
