package com.lizhi.guide.entity;

import java.util.Date;

public class CodeRecord {

    private Long recordId;

    private Long recordTeamProjectId; // 返回的gitlab项目id

    private String recordCommitName; // 返回提交的提交人

    private String recordCommitMessage; //返回提交发布的信息

    private String recordCommitVersion; //返回的版本号

    private Date recordCreateTime; //返回代码发布时间戳

    public CodeRecord(Long recordId, Long recordTeamProjectId, String recordCommitName, String recordCommitMessage, String recordCommitVersion, Date recordCreateTime) {
        this.recordId = recordId;
        this.recordTeamProjectId = recordTeamProjectId;
        this.recordCommitName = recordCommitName;
        this.recordCommitMessage = recordCommitMessage;
        this.recordCommitVersion = recordCommitVersion;
        this.recordCreateTime = recordCreateTime;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRecordTeamProjectId() {
        return recordTeamProjectId;
    }

    public void setRecordTeamProjectId(Long recordTeamProjectId) {
        this.recordTeamProjectId = recordTeamProjectId;
    }

    public String getRecordCommitName() {
        return recordCommitName;
    }

    public void setRecordCommitName(String recordCommitName) {
        this.recordCommitName = recordCommitName;
    }

    public String getRecordCommitMessage() {
        return recordCommitMessage;
    }

    public void setRecordCommitMessage(String recordCommitMessage) {
        this.recordCommitMessage = recordCommitMessage;
    }

    public String getRecordCommitVersion() {
        return recordCommitVersion;
    }

    public void setRecordCommitVersion(String recordCommitVersion) {
        this.recordCommitVersion = recordCommitVersion;
    }

    public Date getRecordCreateTime() {
        return recordCreateTime;
    }

    public void setRecordCreateTime(Date recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }
}
