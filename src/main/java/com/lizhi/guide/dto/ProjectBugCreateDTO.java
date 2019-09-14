package com.lizhi.guide.dto;

public class ProjectBugCreateDTO {

    private String bugCommitReason;

    private String  bugCommitInfo;

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
}
