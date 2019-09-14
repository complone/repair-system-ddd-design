package com.lizhi.guide.Vo;

import com.lizhi.guide.entity.CodeRecord;

import java.util.List;

public class CodeRecordVo {

    private Integer pageNum;

    private Integer pageTotal;

    private List<CodeRecord> codeRecordList;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<CodeRecord> getCodeRecordList() {
        return codeRecordList;
    }

    public void setCodeRecordList(List<CodeRecord> codeRecordList) {
        this.codeRecordList = codeRecordList;
    }
}
