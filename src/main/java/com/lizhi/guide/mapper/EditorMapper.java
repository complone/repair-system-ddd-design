package com.lizhi.guide.mapper;

import com.lizhi.guide.entity.Editor;

public interface EditorMapper {
    Editor selectEditorByEditorDocumentId(Long documentId);
    int createEditorDocument(Editor editor);
    int updateEditorDocument(Editor editor);

}
