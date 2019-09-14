package com.lizhi.guide.service.impl;


import com.lizhi.guide.common.ResponseResultService.ResponseService;
import com.lizhi.guide.entity.Document;
import com.lizhi.guide.entity.Editor;
import com.lizhi.guide.entity.TeamProject;
import com.lizhi.guide.mapper.DocumentMapper;
import com.lizhi.guide.mapper.EditorMapper;
import com.lizhi.guide.mapper.TeamProjectMapper;
import com.lizhi.guide.service.DocumentService;
import com.lizhi.guide.util.DataTypeUtils;
import com.lizhi.guide.Vo.DocumentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private TeamProjectMapper teamProjectMapper;

    @Autowired
    private EditorMapper editorMapper;

    @Override
    public ResponseService<DocumentVo> subscribeDocument(Long teamProjectId, Integer documentViewId) {

        Document document = documentMapper.selectDocumentByTeamProjectIdAndDocumentViewId(teamProjectId,documentViewId);


        TeamProject teamProject = teamProjectMapper.selectTeamProjectByTeamProjectId(teamProjectId);

        DocumentVo documentVo = new DocumentVo();


        if (document == null){
            document = new Document();
            document.setDocumentContent("Welcome editor project document");
            document.setDocumentTeamProjectId(teamProjectId);
            document.setDocumentViewId(documentViewId);
            document.setUpdateTime(new Date());

            int createDocument = documentMapper.createDocumentByTeamProjectAndDocumentViewId(document);

           documentVo = this.assembleDocumentList(document,teamProject);
            return ResponseService.createBySuccess("创建文档内容",documentVo);
        }

        documentVo = this.assembleDocumentList(document,teamProject);




        return ResponseService.createBySuccess("成功订阅文档内容",documentVo);
    }


    @Override
    public ResponseService<DocumentVo> publishDocument(Long teamProjectId, Integer documentViewId,
                                                       String documentContent,String documentMarkDownContent) {

        //更新文档业务
        Document document =  documentMapper.selectDocumentByTeamProjectIdAndDocumentViewId(teamProjectId,documentViewId);
        document.setDocumentContent(documentContent);
        int row = documentMapper.updateDocumentByTeamProjectAndDocumentViewIdAndDocumentContent(document);

        if (row == 0){
            return ResponseService.createByErrorMessage("更新文档失败");
        }


        TeamProject teamProject = teamProjectMapper.selectTeamProjectByTeamProjectId(document.getDocumentTeamProjectId());

        Editor editor = editorMapper.selectEditorByEditorDocumentId(document.getDocumentId());

        //第一次创建文档,那就推送markdown
        if (editor == null){
            editor = new Editor();
            editor.setEditorDocumentMarkdown("###Welcome to Editor Document");
            editor.setEditorDocumentId(document.getDocumentId());
            int editorRecord =editorMapper.createEditorDocument(editor);
            if (editorRecord == 0){
                return ResponseService.createByErrorMessage("创建文档失败");
            }
        }
        //如果本身已经创建文档
        editor.setEditorDocumentMarkdown(documentMarkDownContent);
        editor.setEditorDocumentId(document.getDocumentId());
        editorMapper.updateEditorDocument(editor);




        DocumentVo documentVo = new DocumentVo();
        documentVo.setDocumentContent(document.getDocumentContent());
        //预留字段，准备给以后介入单点系统作为返回传值
        documentVo.setDocumentProjectCharge(teamProject.getTeamProjectCharge());
        documentVo.setDocumentViewId(document.getDocumentViewId());
        documentVo.setDocumentTeamProjectId(document.getDocumentTeamProjectId());

        return ResponseService.createBySuccess("更新文档成功",documentVo);


    }


    @Override
    public ResponseService<DocumentVo> transferDocument(Integer teamProjectId,Integer docuemntType) {

        TeamProject teamProject = teamProjectMapper.selectTeamProjectByTeamProjectId(DataTypeUtils.TransferFromInttoLong((teamProjectId)));

        if (teamProject == null){
            return  ResponseService.createByErrorMessage("该项目不存在");
        }

        Document document = documentMapper.selectDocumentByTeamProjectIdAndDocumentViewId(DataTypeUtils.TransferFromInttoLong(teamProjectId),docuemntType);


        if (document == null){
            return ResponseService.createByErrorMessage("该文档不存在");
        }



        Editor editor = editorMapper.selectEditorByEditorDocumentId(document.getDocumentId());

        if (editor == null){
            editor = new Editor();
            editor.setEditorDocumentMarkdown("Welcome to Editor Document");
            editor.setEditorDocumentId(document.getDocumentId());
            int row =editorMapper.createEditorDocument(editor);
            if (row == 0){
                return ResponseService.createByErrorMessage("创建文档失败");
            }
        }



        DocumentVo documentVo = new DocumentVo();
        documentVo.setDocumentProjectCharge(teamProject.getTeamProjectCharge());
        documentVo.setDocumentTeamProjectId(DataTypeUtils.TransferFromInttoLong(teamProjectId));
        documentVo.setDocumentViewId(docuemntType);
        documentVo.setDocumentContent(editor.getEditorDocumentMarkdown());


        return ResponseService.createBySuccess("成功返回该项目文档",documentVo);
    }


    public DocumentVo assembleDocumentList(Document document,TeamProject teamProject){
        DocumentVo documentVo = new DocumentVo();
        documentVo.setDocumentTeamProjectId(document.getDocumentTeamProjectId());
        documentVo.setDocumentViewId(document.getDocumentViewId());
        documentVo.setDocumentProjectCharge(teamProject.getTeamProjectCharge());
        documentVo.setDocumentContent(document.getDocumentContent());
        return documentVo;
    }
}
