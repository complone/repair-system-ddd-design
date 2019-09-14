package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.Team;

import java.util.List;

public interface TeamMapper {

    String selectTeamNameByTeamId(Integer teamId);

    Team selectTeamByTeamId(Integer teamId);






}
