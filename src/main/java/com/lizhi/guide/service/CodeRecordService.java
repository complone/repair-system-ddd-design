package com.lizhi.guide.service;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.CodeRecord;

import java.util.List;

public interface CodeRecordService {

    ResponseService<List<CodeRecord>> importCodeRecordList (Integer teamProjectId,Integer pageNum,Integer pageSize);




}
