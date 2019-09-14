package com.lizhi.guide.handler.HttpResponseExceptionHandler;


import com.lizhi.guide.common.ResponseResultService.ResponseExceptionService;
import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.Document;
import com.lizhi.guide.exception.DocumentException;
import com.lizhi.guide.exception.ProjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@ControllerAdvice
//public class ResponseExceptionHandler {
//
//    @ExceptionHandler(ProjectException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ResponseExceptionService handlerProjectRuntimeException(ProjectException px){
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        logger.error("业务异常："+px.getMessage());
//        return ResponseExceptionService.error(px.getCode(),px.getMessage());
//    }
//
//    @ExceptionHandler(DocumentException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ResponseExceptionService handlerDocumentRuntimeException(DocumentException dx){
//
//
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        logger.error("业务异常："+dx.getMessage());
//        return ResponseExceptionService.error(dx.getCode(),dx.getMessage());
//    }
//
//}
