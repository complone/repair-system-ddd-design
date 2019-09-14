package com.lizhi.guide.service;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.Vo.TeamProjectsVo;

public interface TeamProjectService {

    ResponseService<TeamProject> selectTeamProjectByTeamProjectId(Integer teamProjectId);//返回项目的有关信息

    ResponseService<TeamProjectsVo> selectTeamProjectListByTeamProjectId(Integer teamId);//返回项目的有关信息

    ResponseService<TeamProject>createProjectByProjectDetail(Integer teamId, String projectName,
                                                                           String projectCharge,String projectDescrption,
                                                                           String projectRespoURL);


}
