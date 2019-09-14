package com.lizhi.guide.service.impl;

import com.lizhi.guide.Vo.CodeRecordVo;
import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.CodeRecord;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.mapper.CodeRecordMapper;
import com.lizhi.guide.mapper.TeamProjectMapper;
import com.lizhi.guide.service.CodeRecordService;
import com.lizhi.guide.util.DataTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("codeRecordService")
public class CodeRecordServiceImpl implements CodeRecordService {

    @Autowired
    private CodeRecordMapper codeRecordMapper;

    @Autowired
    private TeamProjectMapper teamProjectMapper;

    @Override
    public ResponseService<List<CodeRecord>> importCodeRecordList(Integer teamProjectId,Integer pageNum,Integer pageSize) {


        TeamProject teamProject = teamProjectMapper.selectTeamProjectByTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProjectId));

        CodeRecordVo codeRecordVo  = new CodeRecordVo();
        codeRecordVo.setPageNum(pageNum);

        //从服务获取的值
        List<CodeRecord> codeRecordList = codeRecordMapper.selectCodeRecordByTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProjectId));

        //设置回传列表

        if (codeRecordList == null){
            return  ResponseService.createByErrorMessage("导入代码发布记录失败");
        }

        return ResponseService.createBySuccess("导入项目发布记录成功",codeRecordList);
    }
}
