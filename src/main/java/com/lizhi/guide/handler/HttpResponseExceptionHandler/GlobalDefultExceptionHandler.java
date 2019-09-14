package com.lizhi.guide.handler.HttpResponseExceptionHandler;


import com.lizhi.guide.common.ResponseEnum.ResponseExceptionCode;
import com.lizhi.guide.common.ResponseResultService.ResponseExceptionService;
import com.lizhi.guide.exception.DocumentException;
import com.lizhi.guide.exception.ProjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;

@ControllerAdvice
public class GlobalDefultExceptionHandler {



    @ExceptionHandler(ProjectException.class) //声明捕获的类型异常
    @ResponseBody
    public ResponseExceptionService defultProjectExcepitonHandler(Exception e) {
        System.out.println(e);
        if(e instanceof ProjectException) {
            ProjectException projectException = (ProjectException)e;
            //比较是否已经触发自定义局部异常
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.error("业务异常："+projectException.getMessage());
            return ResponseExceptionService.error(projectException.getCode(), projectException.getMessage());
        }
        //未知错误
        return ResponseExceptionService.error(-1, "系统异常：\\n"+e);
    }

    @ExceptionHandler(DocumentException.class) //声明捕获的类型异常
    @ResponseBody
    public ResponseExceptionService defaultDocumentException(Exception e){
      if (e instanceof DocumentException){
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.error("业务异常："+e.getMessage());
            DocumentException documentException = (DocumentException)e;
            return ResponseExceptionService.error(documentException.getCode(), documentException.getMessage());
        }
        //未知错误
        return ResponseExceptionService.error(-1, "系统异常：\\n"+e);
    }


}
