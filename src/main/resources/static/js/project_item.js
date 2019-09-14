$(function () {

    //所有发生在项目条目内的响应事件

    function bindProjectAboutEvent () {
        const $li = $('.js-project-about');

        $li.click(function () {
            var type = $(this).data('type')
            var title = $(this).find('a').text()
            var curSearch = window.location.search
            //将当前视图id添加到url后面,页面不跳转
            if (curSearch) {
                if (curSearch.indexOf('type=') > -1) {
                    curSearch = curSearch.replace(/type=\d+/, 'type=' + type)
                } else {
                    curSearch += ('&type=' + type)
                }
            } else {
                curSearch = '?type=' + type
            }

            //添加当前显示class,便于转发请求查找
            $(this).addClass('active').siblings().removeClass('active');

            var url = (window.location.protocol) + '//'
                + window.location.host
                + window.location.pathname
                + curSearch
                + window.location.hash;

            window.history.pushState({}, title, url)
        })
    }

    //点击项目条目
    $("body").on('click', " #projectListContent .col-md-2 .list-unstyled li a", function () {


        $(".footer").empty();
        //显示项目导航栏内容
        $("#projectItemNav").show();
        $(' #projectNav').hide();

        var teamProjectId = $(this).data("value");
        $.ajax({
            url: "../project/selectDocumentByTeamProjectId/" + "1/"+teamProjectId,
            type: "post",
            traditional: true,
            success: function (result) {

                // $('.nav.navbar-nav.ml-auto').empty();
                // var nav_project_about = '     <li class="nav-item active js-project-about" data-type="1">\n' +
                //     '                            <a class="nav-link" href="javascript:void(0)" id="document" data-toggle="tab">Document</a>\n' +
                //     '                        </li>\n' +
                //     '                        <li class="nav-item active js-project-about" data-type="2">\n' +
                //     '                            <a class="nav-link" href="javascript:void(0)" id="respo" data-toggle="tab">respo</a>\n' +
                //     '                        </li>\n' +
                //     '\n' +
                //     '                        <li class="nav-item active js-project-about" data-type="3">\n' +
                //     '                            <a class="nav-link" href="javascript:void(0)" id="demo" data-toggle="tab">Demo</a>\n' +
                //     '                        </li>\n' +
                //     '                        <li class="nav-item active js-project-about" data-type="4">\n' +
                //     '                            <a class="nav-link" href="javascript:void(0)" id="record" data-toggle="tab">record</a>\n' +
                //     '                        </li>\n' +
                //     '                        <li class="nav-item active js-project-about" data-type="5">\n' +
                //     '                            <a class="nav-link" href="javascript:void(0)" id="commit" data-toggle="tab">Commit Bug</a>\n' +
                //     '                        </li>';




                // $('.nav.navbar-nav.ml-auto').html(nav_project_about);


                var editormd = '<div class="panel-body">\n' +
                    '            <div class="row" style="margin: 0 auto;">\n' +
                    '                <div id="my-editormd-preview" class="col-md-12  content editormd-preview-theme" style="height: 640px;">\n' +
                    result.data.documentContent +
                    '                </div>\n' +
                    '                <button class="button button-primary button-pill button-large btn-project-preview" >编辑内容</button>\n' +
                    '            </div>\n' +
                    '        </div>';


                var projectCharge = '负责人： '+result.data.documentProjectCharge;


                $(".footer").empty();
                $(".footer").append(projectCharge);



                var Project = document.getElementById("projectDetail");
                var ProjectId = document.createAttribute("value");
                ProjectId.value = teamProjectId;
                Project.setAttributeNode(ProjectId);




                //editmd load srcipt

                $(' #projectList').hide();
                $('#projectDetail').empty();
                $(' #projectDetail').append(editormd);
                $(' #projectDetail').show();
                bindProjectAboutEvent()
            }
        })
    });


    $("body").on('click','.btn-project-save', function () {
        var projectName = $("input[name='projectName']").val();
        var projectCharge = $("input[name='projectCharge']").val();
        var projectDescrption = $("input[name='projectDescrption']").val();
        var projectTeamId = $("#projectList").attr("value");


        $.ajax({
            url: "../project/createTeamProject",
            type: "post",
            data:JSON.stringify({teamId:projectTeamId,projectName:projectName,
                projectCharge:projectCharge,projectDescrption:projectDescrption}),
            dataType: "json",
            contentType : 'application/json',
            traditional: true,
            success: function (result) {
                console.log(result.msg);
            }
        })

    })



    $("body").on('click','.btn-project-preview', function () {


        //var _id = $(this).attr('data-type');

        var documentViewId =$(".nav-item.js-project-about.active").attr("data-type");

        var projectId = document.getElementById("projectDetail").getAttribute("value");
        // $("#my-editormd-preview").html('<textarea id="editor-html-preview" style="display: none"></textarea>')
        // var content = $(".editormd-markdown-textarea").val();//获取需要转换的文本
        // $("#editor-html-preview").val(content);
        // editormd.markdownToHTML("my-editormd-preview", {
        //     htmlDecode: "style,script,iframe", //可以过滤标签解码
        //     emoji: true,
        //     taskList: true,
        //     tex: true,               // 默认不解析
        //     flowChart: true,         // 默认不解析
        //     sequenceDiagram: true,  // 默认不解析
        // });

        window.location = "/user/buildProject?projectId="+projectId+"&documentViewId="+documentViewId;
    })


});