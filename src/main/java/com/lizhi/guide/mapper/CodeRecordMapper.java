package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.CodeRecord;

import java.util.List;

public interface CodeRecordMapper {

    List<CodeRecord> selectCodeRecordByTeamProjectId(Long teamProjectId);

    int createCodeRecordByCodeRecord(CodeRecord codeRecord);

    int createCodeRecordListByCodeRecord(List<CodeRecord> codeRecordList);


}
