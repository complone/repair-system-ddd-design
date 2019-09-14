package com.lizhi.guide.Vo;

import com.lizhi.guide.Bo.PageDetailBo;
import com.lizhi.guide.Do.BugCommitDo;
import com.lizhi.guide.entity.BugCommit;

import java.util.List;

public class BugCommitVo {
    private Integer teamProject;

    private PageDetailBo<BugCommitDo> bugCommitRecord;

    public PageDetailBo<BugCommitDo> getBugCommitRecord() {
        return bugCommitRecord;
    }

    public void setBugCommitRecord(PageDetailBo<BugCommitDo> bugCommitRecord) {
        this.bugCommitRecord = bugCommitRecord;
    }

    public Integer getTeamProject() {
        return teamProject;
    }

    public void setTeamProject(Integer teamProject) {
        this.teamProject = teamProject;
    }


}
