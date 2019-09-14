package com.lizhi.guide.Vo;

import com.lizhi.guide.entity.TeamProject;

import java.util.List;

public class TeamProjectsVo {

    private Integer teamId;

    private String teamProjectName;

    private List<TeamProject> projectList;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamProjectId(Integer teamId) {
        this.teamId = teamId;
    }

    public List<TeamProject> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<TeamProject> projectList) {
        this.projectList = projectList;
    }

    public String getTeamProjectName() {
        return teamProjectName;
    }

    public void setTeamProjectName(String teamProjectName) {
        this.teamProjectName = teamProjectName;
    }
}
