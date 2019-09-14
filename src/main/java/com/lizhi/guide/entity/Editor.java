package com.lizhi.guide.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

public class Editor {

    @JsonIgnore(value = false)
    private Long editorId; //用户编辑记录

    private Long editorDocumentId; // 用户编辑的文档id

    private String editorDocumentMarkdown; //用户面向项目主页所编辑的文档markdown

    private Date createTime ; //开始编辑时间

    private Date updateTime; //最后一次编辑时间


    public Editor(Long editorId, Long editorDocumentId, String editorDocumentMarkdown, Date createTime, Date updateTime) {
        this.editorId = editorId;
        this.editorDocumentId = editorDocumentId;
        this.editorDocumentMarkdown = editorDocumentMarkdown;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Editor(){
        super();
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }

    public Long getEditorDocumentId() {
        return editorDocumentId;
    }

    public void setEditorDocumentId(Long editorDocumentId) {
        this.editorDocumentId = editorDocumentId;
    }

    public String getEditorDocumentMarkdown() {
        return editorDocumentMarkdown;
    }

    public void setEditorDocumentMarkdown(String editorDocumentMarkdown) {
        this.editorDocumentMarkdown = editorDocumentMarkdown;
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
