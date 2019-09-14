package com.lizhi.guide.service;

import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.Vo.DocumentVo;

public interface DocumentService {


    //订阅文档服务 ,只返回文档
    ResponseService<DocumentVo> subscribeDocument(Long teamProjectId, Integer documentViewId);


   //发布文档服务,返回状态
    ResponseService<DocumentVo> publishDocument(Long teamProjectId, Integer documentViewId,String documentContent,String documentMarkDownContent);


   // 转换文档格式服务
    ResponseService<DocumentVo> transferDocument(Integer teamProjectId,Integer docuemntType);

}
