package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.Document;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    Document selectDocumentByTeamProjectIdAndDocumentViewId(@Param("documentTeamProjectId") Long documentTeamProjectId, @Param("documentViewId") Integer documentViewId);

    int updateDocumentByTeamProjectAndDocumentViewIdAndDocumentContent(Document document);

    int createDocumentByTeamProjectAndDocumentViewId(Document document);

}
