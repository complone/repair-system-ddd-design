package com.lizhi.guide.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Blob;
import java.util.Date;

public class Document {

    private Long documentId;

    private String documentContent;

    private Integer documentViewId;

    private Long documentTeamProjectId;

    private Date createTime;

    private Date updateTime;

    public Document(Long documentId, String documentContent, Integer documentViewId, Long documentTeamProjectId, Date createTime, Date updateTime) {
        this.documentId = documentId;
        this.documentContent = documentContent;
        this.documentViewId = documentViewId;
        this.documentTeamProjectId = documentTeamProjectId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Document(){
        super();
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public Long getDocumentTeamProjectId() {
        return documentTeamProjectId;
    }

    public void setDocumentTeamProjectId(Long documentTeamProjectId) {
        this.documentTeamProjectId = documentTeamProjectId;
    }



    public Integer getDocumentViewId() {
        return documentViewId;
    }

    public void setDocumentViewId(Integer documentViewId) {
        this.documentViewId = documentViewId;
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
