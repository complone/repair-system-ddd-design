package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.BugCommit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugCommitMapper {

    int addBugCommitIdByBugCommit(BugCommit bugCommit);

    int updateBugCommitIdByBugCommit(BugCommit bugCommit);

    BugCommit selectBugCommitByBugCommitTeamProjectId(Long bugCommitTeamProjectId);

    int seletTotalRowsByBugCommitByTeamProjectId(Long bugCommitTeamProjectId);

    List<BugCommit> selectBugCommitListByBugCommitTeamProjectId(@Param("bugCommitTeamProjectId") Long bugCommitTeamProjectId,
                                                                @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);



}
