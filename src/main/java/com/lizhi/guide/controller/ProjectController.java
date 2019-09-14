package com.lizhi.guide.controller;

import com.lizhi.guide.Do.BugCommitDo;
import com.lizhi.guide.common.Const;
import com.lizhi.guide.common.ResponseResultService.ResponseFileService;
import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.dto.*;
import com.lizhi.guide.entity.*;
import com.lizhi.guide.mapper.EditorMapper;
import com.lizhi.guide.service.*;
import com.lizhi.guide.util.DataTypeUtils;
import com.lizhi.guide.util.FileUploadUtils;
import com.lizhi.guide.Vo.BugCommitVo;
import com.lizhi.guide.Vo.DocumentVo;
import com.lizhi.guide.Vo.TeamProjectsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamProjectService teamProjectService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private CodeRecordService codeRecordService;

    @Autowired
    private BugCommitService bugCommitService;



    //获取该部门最新的项目列表
    @RequestMapping(value = "/selectTeamProjectByTeamId/{teamId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseService<TeamProjectsVo> selectTeamProjectListByTeamId(@PathVariable("teamId") Integer teamId) {

            if (teamId == null){
                return ResponseService.createByErrorMessage("该部门不存在");
            }

        return  teamService.selectTeamProjectListByTeamId(teamId);
    }


    //获取最新的项目列表,按字典序排序
    @RequestMapping(value = "/projectlist/{teamId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseService<HashMap<String,List<TeamProject>>> getproject(@PathVariable("teamId") Integer teamId) {

        System.out.println(teamId);

        if (teamId == null){
            return ResponseService.createByErrorMessage("该部门不存在");
        }

        return teamService.selectProjectListMapByTeamProjectId(teamId);
    }

    //需要重构成文档的方法,支持上传到数据库的text方法(发布文档动作)
    @RequestMapping(value = "/selectDocumentByTeamProjectId/{documentType}/{teamProjectId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService selectTeamProjectDocument(@PathVariable("documentType") Integer docuemntType,
                                                     @PathVariable("teamProjectId") Integer teamProjectId){

        if (teamProjectId == null){
            return   ResponseService.createByErrorMessage("没有该项目");
        }


        return documentService.subscribeDocument(DataTypeUtils.TransferFromInttoLong(teamProjectId),docuemntType);
    }

    @RequestMapping(value = "/publishTeamProjectDocument/{documentType}/{teamProjectId}",method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseService<DocumentVo> publishTeamProjectDocument(@PathVariable("documentType") Integer docuemntType,
                                                                  @PathVariable("teamProjectId") Integer teamProjectId,
                                                                  @RequestBody ProjectDocumentContentDTO projectDocumentContentDTO){
        if (teamProjectId == null){
            return ResponseService.createByErrorMessage("没有该项目");
        }

        System.out.println(projectDocumentContentDTO.getTeamProjectDocumentMarkDownContent());

        //传递单参数使用
//        JSONObject jsonObject = JSONObject.parseObject(projectDocumentContentDTO.getTeamProjectDocumentContent());
//        String documentContent = jsonObject.getString("teamProjectDocumentContent");

        return documentService.publishDocument(DataTypeUtils.TransferFromInttoLong(teamProjectId),docuemntType,
                projectDocumentContentDTO.getTeamProjectDocumentContent(), projectDocumentContentDTO.getTeamProjectDocumentMarkDownContent());
    }

    @RequestMapping(value = "/viewTeamProjectMdDocument",method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseService<DocumentVo> viewTeamProjectMdDocument(@RequestBody ProjectDocumentTypeDTO projectDocumentTypeDTO){
        if (projectDocumentTypeDTO.getTeamProjectId() == null){
            return ResponseService.createByErrorMessage("没有该项目");
        }


        return documentService.transferDocument(projectDocumentTypeDTO.getTeamProjectId(), projectDocumentTypeDTO.getDocumentType());
    }



    //需要重新构建代码发布记录的方法
    @RequestMapping(value = "/selectCodeRecordByTeamProjectId/{teamProjectId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService projectCodeRecord(@PathVariable("teamProjectId") Integer teamProjectId,@RequestBody PageDetailDTO pageDetailDTO){

        if(teamProjectId == null){
            return ResponseService.createByErrorMessage("该项目不存在");
        }

        return codeRecordService.importCodeRecordList(teamProjectId,
                pageDetailDTO.getPageNum(),pageDetailDTO.getPageSize());
    }

    //编辑单个bug
    @RequestMapping(value = "/editorBugCommitByTeamProjectId/{teamProjectId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService<BugCommitDo> editorProjectBugCommit(@PathVariable("teamProjectId") Integer teamProjectId,
                                                               @RequestBody ProjectBugEditorDTO projectBugEditorDTO){

        if (teamProjectId == null){
            return ResponseService.createByErrorMessage("该项目不存在");
        }


        return bugCommitService.editorBugCommit(teamProjectId,projectBugEditorDTO.getBugCommitReason(),projectBugEditorDTO.getBugCommitInfo());
    }

    //新增bug接口
    @RequestMapping(value = "/createBugCommitByTeamProjectId/{teamProjectId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService addProjectBugCommit(@PathVariable("teamProjectId") Integer teamProjectId,
                                               @RequestBody ProjectBugCreateDTO projectBugCreateDTO){
        if (teamProjectId == null){
            return ResponseService.createByErrorMessage("该项目不存在");
        }

        return bugCommitService.createCommitBug(teamProjectId,projectBugCreateDTO.getBugCommitReason(),projectBugCreateDTO.getBugCommitInfo());

    }


    //批量选择bug提交记录
    @RequestMapping(value = "/selectBugCommitByPageHelper/{teamProjectId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService<BugCommitVo> projectBugCommitPage(@PathVariable("teamProjectId") Integer teamProjectId, @RequestBody PageDetailDTO pageDetailDTO){


        if (teamProjectId == null){
            return ResponseService.createByErrorMessage("创建项目提交bug失败");
        }
        return bugCommitService.queryBugCommitPage(teamProjectId,pageDetailDTO.getPageNum(),pageDetailDTO.getPageSize());

    }




    //md图片上传接口,支持上传到服务器的资源目录
    @RequestMapping(value = "/saveTeamProjectDocumentMdFile",method = RequestMethod.POST)
    @ResponseBody
    public ResponseFileService uploadTeamProjectDocument(@RequestParam(value = "editormd-image-file",required = true)MultipartFile file){

        String fileName = FileUploadUtils.UploadFileNameHandler(file,Const.FilePath.DOCUMENT_UPLOAD_PATH);

        return ResponseFileService.createBySuccess("uploads Success!",fileName);

    }


    //md文本上传接口,支持上传到数据库的text类型字段
    @RequestMapping(value = "/uploadDocumentByDoucmentTeamProjectId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseService uploadTeamProjectMarkDown(Integer doucmentTeamProjectId,Integer documentViewId,String documentContent){


        if (doucmentTeamProjectId == null){
            return ResponseService.createByErrorMessage("该文档视图不存在");
        }


        return ResponseService.createBySuccess("文档更新成功",1);
    }


    //md文本上传接口,支持上传到服务器的目录
    @RequestMapping(value = "/selectTeamProjectMarkDownFile",method = RequestMethod.POST)
    @ResponseBody
    public ResponseFileService uploadTeamProjectMarkDown(String title,String editmd){

        String fileName = FileUploadUtils.WriteEditorMd(title,editmd,Const.FilePath.DOCUMENT_TEST);
        String msg = FileUploadUtils.WriteEditorMd(title,editmd,Const.FilePath.DOCUMENT_TEST);

        if (title == ""){
            return ResponseFileService.createMDByError(msg,fileName);
        }


        return ResponseFileService.createMDBySuccess(msg,fileName);
    }


    @RequestMapping(value = "/selectTeamProjectMarkDownFile",method = RequestMethod.GET)
    @ResponseBody
    public ResponseFileService uploadTeamProjectMarkwn(String title,String editmd){

        String fileName = FileUploadUtils.WriteEditorMd(title,editmd,Const.FilePath.DOCUMENT_TEST);
        String msg = FileUploadUtils.WriteEditorMd(title,editmd,Const.FilePath.DOCUMENT_TEST);

        if (title == ""){
            return ResponseFileService.createMDByError(msg,fileName);
        }


        return ResponseFileService.createMDBySuccess(msg,fileName);
    }




    @RequestMapping(value = "/createTeamProject",method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseService createProject(@RequestBody ProjectDTO projectDTO){

        if (projectDTO.getTeamId() == null){
            return ResponseService.createByErrorMessage("项目所属部门不存在");
        }

        return teamProjectService.createProjectByProjectDetail(projectDTO.getTeamId(), projectDTO.getProjectName(),
                projectDTO.getProjectCharge(),projectDTO.getProjectDescrption(),
                projectDTO.getProjectRespoURL());
    }

    @Autowired
    private EditorMapper editorMapper;


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String test(){
        Editor editor = editorMapper.selectEditorByEditorDocumentId(DataTypeUtils.TransferFromInttoLong(3));
        System.out.println(editor.getEditorDocumentMarkdown());
        if (editor.getEditorId() == null){
            return "error";
        }
        return "success";
    }

}
