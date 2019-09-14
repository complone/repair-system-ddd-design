package com.lizhi.guide.service.impl;

import com.google.common.collect.Lists;
import com.lizhi.guide.Bo.PageDetailBo;
import com.lizhi.guide.Do.BugCommitDo;
import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.BugCommit;
import com.lizhi.guide.mapper.BugCommitMapper;
import com.lizhi.guide.service.BugCommitService;
import com.lizhi.guide.util.DataTypeUtils;
import com.lizhi.guide.Vo.BugCommitVo;
import com.lizhi.guide.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("bugCommitService")
public class BugCommitServiceImpl implements BugCommitService{

    @Autowired
    private BugCommitMapper bugCommitMapper;

    @Override
    public ResponseService<BugCommitVo> queryBugCommitPage(Integer teamProjectId,int pageNum,int pageSize) {


        List<BugCommit> bugCommitList = bugCommitMapper.selectBugCommitListByBugCommitTeamProjectId(
                DataTypeUtils.TransferFromInttoLong(teamProjectId),
                (pageNum-1)*pageSize,pageSize);


        if (bugCommitList == null){
            return ResponseService.createByErrorMessage("该项目不存在bug提交记录");
        }
        List<BugCommitDo> bugCommitViewList = Lists.newArrayList();

        for (BugCommit commit: bugCommitList){

            BugCommitDo bugCommitDo = new BugCommitDo();
            bugCommitDo.setBugCommitReason(commit.getBugCommitReason());
            bugCommitDo.setBugCommitInfo(commit.getBugCommitInfo());
            bugCommitDo.setCreateTime(DateTimeUtils.dateToStr(commit.getCreateTime()));
            bugCommitDo.setUpdateTime(DateTimeUtils.dateToStr(commit.getUpdateTime()));
            bugCommitViewList.add(bugCommitDo);

        }

        int count = bugCommitMapper.seletTotalRowsByBugCommitByTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProjectId));


        PageDetailBo<BugCommitDo> pageDetailBo = new PageDetailBo<>();
        pageDetailBo.setPageSize(pageSize);
        pageDetailBo.setPageNum(pageNum);
        pageDetailBo.setList(bugCommitViewList);
        pageDetailBo.setTotal(count);

        BugCommitVo bugCommitVo = new BugCommitVo();
        bugCommitVo.setBugCommitRecord(pageDetailBo);
        bugCommitVo.setTeamProject(teamProjectId);

        return ResponseService.createBySuccess("成功获取项目bug提交记录",bugCommitVo);
    }

    @Override
    public ResponseService<BugCommitDo> editorBugCommit(Integer teamProject,String bugCommitReason,String bugCommitInfo) {
        BugCommit bugCommit = bugCommitMapper.selectBugCommitByBugCommitTeamProjectId(
                DataTypeUtils.TransferFromInttoLong(teamProject));
        if (bugCommit == null){
            return ResponseService.createByErrorMessage("未有可编辑的bug提交记录");
        }


        bugCommit.setBugCommitReason(bugCommitReason);
        bugCommit.setBugCommitInfo(bugCommitInfo);
        bugCommitMapper.updateBugCommitIdByBugCommit(bugCommit);

        BugCommitDo bugCommitDo = new BugCommitDo();;
        bugCommitDo.setBugCommitReason(bugCommit.getBugCommitReason());
        bugCommitDo.setBugCommitInfo(bugCommit.getBugCommitInfo());
        bugCommitDo.setCreateTime(DateTimeUtils.dateToStr(bugCommit.getCreateTime()));
        bugCommitDo.setUpdateTime(DateTimeUtils.dateToStr(bugCommit.getUpdateTime()));

        return ResponseService.createBySuccess("编辑bug成功",bugCommitDo);
    }


    @Override
    public ResponseService<BugCommitDo> createCommitBug(Integer teamProject,String bugCommitReason,String bugCommitInfo ) {

        BugCommit bugCommit = new BugCommit();
        bugCommit.setBugCommitTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProject));
        bugCommit.setBugCommitReason(bugCommitReason);
        bugCommit.setBugCommitInfo(bugCommitInfo);
        bugCommit.setCreateTime(new Date());
        bugCommit.setUpdateTime(new Date());
        int record = bugCommitMapper.addBugCommitIdByBugCommit(bugCommit);

        if (record == 0){
            return ResponseService.createByErrorMessage("创建bug失败");
        }

        BugCommitDo bugCommitDo = new BugCommitDo();
        bugCommitDo.setBugCommitReason(bugCommit.getBugCommitReason());
        bugCommitDo.setBugCommitInfo(bugCommit.getBugCommitInfo());
        bugCommitDo.setCreateTime(DateTimeUtils.dateToStr(bugCommit.getCreateTime()));
        bugCommitDo.setUpdateTime(DateTimeUtils.dateToStr(bugCommit.getUpdateTime()));


        return ResponseService.createBySuccess("创建bug成功",bugCommitDo);

    }

    public BugCommitDo assembleBugCommitList(BugCommit bugCommit){
       BugCommitDo bugCommitDo = new BugCommitDo();

       bugCommitDo.setBugCommitReason(bugCommit.getBugCommitReason());
       bugCommitDo.setBugCommitInfo(bugCommit.getBugCommitInfo());
       bugCommitDo.setCreateTime(DateTimeUtils.dateToStr(bugCommit.getCreateTime()));
       bugCommitDo.setUpdateTime(DateTimeUtils.dateToStr(bugCommit.getCreateTime()));
       return bugCommitDo;
    }


}
