package com.lizhi.guide.service.impl;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.Team;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.mapper.TeamMapper;
import com.lizhi.guide.mapper.TeamProjectMapper;
import com.lizhi.guide.service.TeamProjectService;
import com.lizhi.guide.util.DataTypeUtils;
import com.lizhi.guide.Vo.TeamProjectsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("teamProjectService")
public class TeamProjectServiceImpl implements TeamProjectService {

    @Autowired
    private TeamProjectMapper teamProjectMapper;

    @Autowired
    private TeamMapper teamMapper;


    @Override
    public ResponseService<TeamProjectsVo> selectTeamProjectListByTeamProjectId(Integer teamId) {
        List<TeamProject> teamProjectList = teamProjectMapper.selectTeamProjectList(teamId);

        Team team = teamMapper.selectTeamByTeamId(teamId);

        TeamProjectsVo teamProjectsVo = this.assembleTeamPorjectList(team,teamProjectList);

        if (teamProjectList == null){
            return ResponseService.createByCodeNodeErrorMessage();
        }

        return ResponseService.createBySuccess(teamProjectsVo);

    }

    @Override
    public ResponseService<TeamProject> selectTeamProjectByTeamProjectId(Integer teamProjectId) {

        TeamProject teamProject = teamProjectMapper.selectTeamProjectByTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProjectId));

        if (teamProject == null){
            return ResponseService.createByErrorMessage("项目不存在");
        }
        return ResponseService.createBySuccess(teamProject);
    }


    @Override
    public ResponseService createProjectByProjectDetail(Integer teamId, String projectName,
                                                                      String projectCharge,String projectDescrption,
                                                                      String projectRespoURL) {

        TeamProject teamProject = new TeamProject();
        teamProject.setTeamId(teamId);
        teamProject.setTeamProjectName(projectName);
        teamProject.setTeamProjectCharge(projectCharge);
        teamProject.setTeamProjectDescrption(projectDescrption);
        teamProject.setTeamProjectAddress(projectRespoURL);
        teamProject.setCreateTime(new Date());
        teamProject.setUpdateTime(new Date());


        if (teamProject.getTeamProjectName() == null){
            return ResponseService.createByErrorMessage("无项目名，创建失败");
        }

        int row = teamProjectMapper.insertTeamProjectIdByTeamProject(teamProject);

        return ResponseService.createBySuccess("创建项目成功",row);
    }

    public TeamProjectsVo assembleTeamPorjectList(Team team, List<TeamProject> teamProjectList){

        TeamProjectsVo teamProjectsVo = new TeamProjectsVo();

        teamProjectsVo.setTeamProjectId(team.getTeamId());
        teamProjectsVo.setTeamProjectName(team.getTeamName());

        teamProjectsVo.setProjectList(teamProjectList);

        return teamProjectsVo;

    }
}
