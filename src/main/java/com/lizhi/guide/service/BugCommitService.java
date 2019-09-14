package com.lizhi.guide.service;

import com.lizhi.guide.Do.BugCommitDo;
import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.BugCommit;
import com.lizhi.guide.Vo.BugCommitVo;

public interface BugCommitService {

    //进入项目拉取bug分页列表
    ResponseService<BugCommitVo> queryBugCommitPage(Integer teamProject,
                                                    int pageNum,int pageSize);

    //编辑项目提交bug页面,关联项目id，和用户操作的bugId条目
    ResponseService<BugCommitDo> editorBugCommit(Integer teamProject, String bugCommitReason, String bugCommitInfo);

    //新建项目bug，根据项目id生成bugid,用来关联用户
    ResponseService<BugCommitDo> createCommitBug(Integer teamProject,String bugCommitReason,String bugCommitInfo);




}
