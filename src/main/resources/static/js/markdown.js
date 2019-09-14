$(function () {


    var split_str = window.location.href.split('?')[1];

    var projectId = split_str.split('&')[0].split('=')[1];

    var documentViewId= split_str.split('&')[1].split('=')[1];


    //当用户进入时渲染md编辑器的ediot部分
    ViewEditoDocument(projectId,documentViewId);

    //当用户进入文档页编辑的时候渲染文档
    function ViewEditoDocument(projectId,documentViewId) {

        $.ajax({
            url: "/project/viewTeamProjectMdDocument",
            type: "post",
            data: JSON.stringify({"teamProjectId":projectId,"documentType":documentViewId}),
            dataType: "json",
            contentType : 'application/json',
            success: function (result) {
                $(".editormd-markdown-textarea").append(result.data.documentContent);
            },
            error: function(){
                $(".editormd-markdown-textarea").append("##Welcome to Editor Document");
            }
        })

    }


    $("body").on('click', '.btn-blog-save',function () {

        $("#formDocuemnt").val("");
        var fileMd = $(".editormd-markdown-textarea").text();//md格式内容，使用md的js获取
        var fileHtml = $(".editormd-html-textarea").text();

        $.ajax({
            url: "/project/publishTeamProjectDocument/"+documentViewId+"/"+projectId,
            type: "post",
            data: JSON.stringify({"teamProjectDocumentContent":fileHtml,"teamProjectDocumentMarkDownContent":fileMd}),
            dataType: "json",
            contentType : 'application/json',
            success: function (result) {
                window.location.href="/user/start";
            }
        })

    });



});