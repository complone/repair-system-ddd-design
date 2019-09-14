package com.lizhi.guide.service.impl;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.mapper.TeamMapper;
import com.lizhi.guide.mapper.TeamProjectMapper;
import com.lizhi.guide.service.TeamService;
import com.lizhi.guide.util.PinyinUtils;
import com.lizhi.guide.Vo.TeamProjectsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;

@Service("teamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamProjectMapper teamProjectMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public ResponseService<TeamProjectsVo> selectTeamProjectListByTeamId(Integer teamId) {

        List<TeamProject> teamProjectList = teamProjectMapper.selectTeamProjectList(teamId);

        String teamName = teamMapper.selectTeamNameByTeamId(teamId);


        TeamProjectsVo teamProjectsVo = new TeamProjectsVo();
        teamProjectsVo.setTeamProjectId(teamId);
        teamProjectsVo.setTeamProjectName(teamName);
        teamProjectsVo.setProjectList(teamProjectList);

        if (teamProjectList == null) {
            return ResponseService.createByErrorMessage("查询部门项目失败");
        }

        return ResponseService.createBySuccess("查询该部门返回列表", teamProjectsVo);
    }


    @Override
    public ResponseService<HashMap<String, List<TeamProject>>> selectProjectListMapByTeamProjectId(Integer teamId) {



        List<TeamProject> list = teamProjectMapper.selectTeamProjectList(teamId);


        HashMap<String, List<TeamProject>> listHashMap = this.directTeamProject(list);
        System.out.println("部门名为: "+teamId);


        return ResponseService.createBySuccess("返回字典序项目列表",listHashMap);
    }

    public HashMap<String, List<TeamProject>> directTeamProject(List<TeamProject> list) {
        //对字典内的对象重排序，现根据id排序在根据项目名称后缀匹配
        Collections.sort(list, new Comparator<TeamProject>() {
            @Override
            public int compare(TeamProject o1, TeamProject o2) {
                Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
                return comparator.compare(o1.getTeamProjectName(), o2.getTeamProjectName());
            }
        });

//        for (TeamProject temp: list){
//            System.out.println(temp.getProjectName());
//        }


        //对排序后的项目进行再分组
        HashMap<String, List<TeamProject>> map = new HashMap<String, List<TeamProject>>();

        for (TeamProject teamProject2 : list) {


            int pos_team = teamProject2.getTeamProjectName().indexOf("-");
            String project_name = String.valueOf(teamProject2.getTeamProjectName().subSequence(pos_team + 1, teamProject2.getTeamProjectName().length()));
            String HEAD_TAG = String.valueOf(PinyinUtils.converterToFirstSpell(project_name).charAt(0));


            if (map.containsKey(HEAD_TAG)) {
                map.get(HEAD_TAG).add(teamProject2);

            } else {

                List<TeamProject> list1 = new ArrayList<TeamProject>();
                list1.add(teamProject2);
                map.put(HEAD_TAG, list1);
            }
        }


//        for (Map.Entry<String, List<TeamProject>> entry : map.entrySet()) {
//            switch (entry.getKey()){
//                case "c":
//                    List<TeamProject> teamProjectList =  map.get("c");
//                    for (TeamProject tp : teamProjectList){
//                        System.out.println(tp.getTeamProjectName()+" --------- "+tp.getTeamProjectId());
//                    }
//            }
        return map;

    }



}
