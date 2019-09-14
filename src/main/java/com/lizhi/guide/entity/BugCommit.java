package com.lizhi.guide.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class BugCommit implements Serializable{

    @JSONField(serialize = false)
    private Long bugCommitId;

    private Long bugCommitTeamProjectId;

    private String bugCommitReason;

    private String  bugCommitInfo;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public BugCommit(Long bugCommitId, Long bugCommitTeamProjectId, String bugCommitReason, String bugCommitInfo, Date createTime, Date updateTime) {
        this.bugCommitId = bugCommitId;
        this.bugCommitTeamProjectId = bugCommitTeamProjectId;
        this.bugCommitReason = bugCommitReason;
        this.bugCommitInfo = bugCommitInfo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BugCommit(){
        super();
    }

    public Long getBugCommitId() {
        return bugCommitId;
    }

    public void setBugCommitId(Long bugCommitId) {
        this.bugCommitId = bugCommitId;
    }

    public Long getBugCommitTeamProjectId() {
        return bugCommitTeamProjectId;
    }

    public void setBugCommitTeamProjectId(Long bugCommitTeamProjectId) {
        this.bugCommitTeamProjectId = bugCommitTeamProjectId;
    }

    public String getBugCommitReason() {
        return bugCommitReason;
    }

    public void setBugCommitReason(String bugCommitReason) {
        this.bugCommitReason = bugCommitReason;
    }

    public String getBugCommitInfo() {
        return bugCommitInfo;
    }

    public void setBugCommitInfo(String bugCommitInfo) {
        this.bugCommitInfo = bugCommitInfo;
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
