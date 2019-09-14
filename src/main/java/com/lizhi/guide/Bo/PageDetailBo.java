package com.lizhi.guide.Bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PageDetailBo<T>{

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    @JSONField(serialize = false)
    private int size;

    //总记录数
    private long total;
    //总页数
    @JSONField(serialize = false)
    private int pages;

    //结果集
    private List<T> list;

    public PageDetailBo(int pageNum, int pageSize, int size, long total, int pages, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.size = size;
        this.total = total;
        this.pages = pages;
        this.list = list;
    }

    public PageDetailBo(){
        super();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
