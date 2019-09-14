package com.lizhi.guide.service;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.Vo.TeamProjectsVo;

import java.util.HashMap;
import java.util.List;

public interface TeamService {

    ResponseService<TeamProjectsVo> selectTeamProjectListByTeamId(Integer teamId); //返回部门id下的所有项目列表

    ResponseService<HashMap<String,List<TeamProject>>> selectProjectListMapByTeamProjectId(Integer teamId); //返回该部门id项目按字典序排序后的项目列表

}
