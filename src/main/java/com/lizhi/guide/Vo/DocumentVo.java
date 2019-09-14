package com.lizhi.guide.Vo;

import com.alibaba.fastjson.annotation.JSONField;

public class DocumentVo {

    private String documentContent;

    @JSONField(serialize=false)
    private Integer documentViewId;

    private Long documentTeamProjectId;


    private String documentProjectCharge;

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public Integer getDocumentViewId() {
        return documentViewId;
    }

    public void setDocumentViewId(Integer documentViewId) {
        this.documentViewId = documentViewId;
    }

    public Long getDocumentTeamProjectId() {
        return documentTeamProjectId;
    }

    public void setDocumentTeamProjectId(Long documentTeamProjectId) {
        this.documentTeamProjectId = documentTeamProjectId;
    }

    public String getDocumentProjectCharge() {
        return documentProjectCharge;
    }

    public void setDocumentProjectCharge(String documentProjectCharge) {
        this.documentProjectCharge = documentProjectCharge;
    }
}
