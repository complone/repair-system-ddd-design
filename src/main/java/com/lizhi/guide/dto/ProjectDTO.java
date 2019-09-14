package com.lizhi.guide.dto;

public class ProjectDTO {

    private Integer teamId;

    private String projectName;

    private String projectDescrption;

    private String projectCharge;

    private String projectRespoURL;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getProjectRespoURL() {
        return projectRespoURL;
    }

    public void setProjectRespoURL(String projectRespoURL) {
        this.projectRespoURL = projectRespoURL;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectCharge() {
        return projectCharge;
    }

    public void setProjectCharge(String projectCharge) {
        this.projectCharge = projectCharge;
    }

    public String getProjectDescrption() {
        return projectDescrption;
    }

    public void setProjectDescrption(String projectDescrption) {
        this.projectDescrption = projectDescrption;
    }
}
