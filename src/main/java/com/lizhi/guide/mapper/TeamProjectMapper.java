package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.TeamProject;

import java.util.List;

public interface TeamProjectMapper {
    List<TeamProject> selectTeamProjectList(Integer teamId);

    int insertTeamProjectIdByTeamProject(TeamProject teamProject);

    TeamProject selectTeamProjectByTeamProjectId(Long teamProjectId);

}
