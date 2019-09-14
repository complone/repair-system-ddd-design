$(function () {



    //字典序列表所在id


    // $("#tabList li").on('click',function () {
    //     $('.nav.navbar-nav.ml-auto').empty();
    //
    //     var nav_origin = '<li class="nav-item active">\n' +
    //         '                            <a class="nav-link" href="#" id="tab_1" data-toggle="tab">Project List</a>\n' +
    //         '                        </li>\n' +
    //         '                        <li class="nav-item active">\n' +
    //         '                            <a class="nav-link" href="#" id="tab_2" data-toggle="tab">New Project</a>\n' +
    //         '                        </li>';
    //
    //     $('.nav.navbar-nav.ml-auto').html(nav_origin);
    //
    // });


    $("#projectItemNav").hide();
    $(' #projectNav').show();


    tabChange();

    function tabChange() {

        $("body").on('click','#tabList li',function () {

            //切换主页，隐藏条目导航栏，显示项目列表导航栏
            $("#projectItemNav").hide();
            $(' #projectNav').show();

            //切换主页,隐藏项目条目内容，显示项目列表内容
            $("#projectDetail").hide();
            $("#projectList").show();

          //   //重置右侧标题DOM结构
          //   $('.nav.navbar-nav.ml-auto').empty()
          //
          //   var rightNav = '<li class="nav-item active">\n' +
          // '                            <a class="nav-link" href="#" id="tab_1">Project List</a>\n' +
          // '                        </li>\n' +
          // '\n' +
          // '                        <li class="nav-item active">\n' +
          // '                            <a class="nav-link" data-target="#myModal" data-toggle="modal" id="tab_2">New Project</a>\n' +
          // '                        </li>';
          //
          //   $('.nav.navbar-nav.ml-auto').html(rightNav);



            $(this).addClass('active').siblings().removeClass('active');
            var _id = $(this).attr('data-id');
            var teamId = $(this).attr('id');

            //设置当前显示的团队id
            var Project = document.getElementById("projectList");
            var ProjectId = document.createAttribute("value");
            ProjectId.value = teamId;
            Project.setAttributeNode(ProjectId);
            // history.pushState(_id,null,"/user/start");

            $('.tab-contents').find('#' + _id).addClass('active').siblings().removeClass('active');
            $("#tabContent"+teamId).empty();
            switch (_id) {


                case "tabContent1":

                    // $("#tabContent2").empty();
                    // $("#tabContent3").empty();
                    // $("#tabContent4").empty();
                    fillTabContent(teamId);
                    fillTeamProject(teamId);
                    break;
                case "tabContent2":
                    // $("#tabContent1").empty();
                    // $("#tabContent3").empty();
                    // $("#tabContent4").empty();
                    fillTabContent(teamId);
                    fillTeamProject(teamId);
                    break;
                case "tabContent3":
                    // $("#tabContent1").empty();
                    // $("#tabContent2").empty();
                    // $("#tabContent4").empty();
                    fillTabContent(teamId);
                    fillTeamProject(teamId);
                    break;
                case "tabContent4":
                    // $("#tabContent1").empty();
                    // $("#tabContent2").empty();
                    // $("#tabContent3").empty();
                    fillCodeSearch();
                    break;
            }

        });



        function fillTeamProject(teamId) {



            var directoryList =  $("#tabContent"+teamId).find(".letter-header");


            $("#projectListContent .col-md-2 .list-unstyled li a").empty();
            $.ajax({
                url: "../project/projectlist/"+teamId,
                type: "post",
                traditional: true,
                success: function (result) {
                    viewProjectList(result,teamId);
                }
            });

        }

        function fillCodeSearch() {
            $.ajax({
                url: "../user/testCodeSearch",
                type: "post",
                traditional: true,
                success: function (data) {
                    $("#tabContent4").empty();
                    $("#tabContent4").append(data);
                }
            });
        }

        function viewProjectList(result,teamId) {



            var projectListLength = Object.keys(result.data).length;
            for (var i = 0; i <projectListLength; i++) {


                switch (Object.keys(result.data)[i]) {
                    case "a":
                        insertProjectNode(teamId,result.data,"A",i);
                        break;
                    case "b":
                        insertProjectNode(teamId,result.data,"B",i);
                        break;
                    case "c":
                        insertProjectNode(teamId,result.data,"C",i);
                        break;
                    case "d":
                        insertProjectNode(teamId,result.data,"D",i);
                        break;
                    case "e":
                        insertProjectNode(teamId,result.data,"E",i);
                        break;
                    case "f":
                        insertProjectNode(teamId,result.data,"F",i);
                        break;
                    case "g":
                        insertProjectNode(teamId,result.data,"G",i);
                        break;
                    case "h":
                        insertProjectNode(teamId,result.data,"H",i);
                        break;
                    case "i":
                        insertProjectNode(teamId,result.data,"I",i);
                        break;
                    case "j":
                        insertProjectNode(teamId,result.data,"J",i);
                        break;
                    case "k":
                        insertProjectNode(teamId,result.data,"K",i);
                        break;
                    case "l":
                        insertProjectNode(teamId,result.data,"L",i);
                        break;
                    case "m":
                        insertProjectNode(teamId,result.data,"M",i);
                        break;
                    case "n":
                        insertProjectNode(teamId,result.data,"N",i);
                        break;
                    case "o":
                        insertProjectNode(teamId,result.data,"O",i);
                        break;
                    case "p":
                        insertProjectNode(teamId,result.data,"P",i);
                        break;
                    case "q":
                        insertProjectNode(teamId,result.data,"Q",i);
                        break;
                    case "r":
                        insertProjectNode(teamId,result.data,"R",i);
                        break;
                    case "s":
                        insertProjectNode(teamId,result.data,"S",i);
                        break;
                    case "t":
                        insertProjectNode(teamId,result.data,"T",i);
                        break;
                    case "u":
                        insertProjectNode(teamId,result.data,"U",i);
                        break;
                    case "v":
                        insertProjectNode(teamId,result.data,"V",i);
                        break;
                    case "w":
                        insertProjectNode(teamId,result.data,"W",i);
                        break;
                    case "x":
                        insertProjectNode(teamId,result.data,"X",i);
                        break;
                    case "y":
                        insertProjectNode(teamId,result.data,"Y",i);
                        break;
                    case "z":
                        insertProjectNode(teamId,result.data,"Z",i);
                        break;

                }
            }

        }

        //组装字典序列表，在字典序列表中插入标签
        function fillTabContent(teamId) {

            var directoryList = ' <div class="container">\n' +
                '                    <div class="row">\n' +
                '                        <div class="col-md-12">\n' +
                '                            <h2>Project List</h2>\n' +
                '                            <!-- not consistent: projects (with sub-projects) or TLPs?\n' +
                '                                 by category = projects,\n' +
                '                                 but other = Top Level Projects only) -->\n' +
                '                        </div>\n' +
                '                        <div class="col-md-12" id="by_name">\n' +
                '                            <h4>By Name</h4>\n' +
                '                            <div class="row" id="projectListContent">\n' +
                '                                <div class="col-md-2">\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;" id="listShow">\n' +
                '                                        <li class="letter-header" id="A">A</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="B">B</li>\n' +
                '                                       \n' +
                '                                        <li class="letter-header" id="C">C</li>\n' +
                '                                    </ul>\n' +
                '                                </div>\n' +
                '                                <div class="col-md-2">\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;">\n' +
                '\n' +
                '                                        <li class="letter-header" id="D">D</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="E">E</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="F">F</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="G">G</li>\n' +
                '\n' +
                '                                    </ul>\n' +
                '\n' +
                '                                </div>\n' +
                '                                <div class="col-md-2">\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;">\n' +
                '                                        <li class="letter-header" id="H">H</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="I">I</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="J">J</li>\n' +
                '\n' +
                '\n' +
                '                                        <li class="letter-header" id="K">K</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="L">L</li>\n' +
                '\n' +
                '                                    </ul>\n' +
                '                                </div>\n' +
                '                                <div class="col-md-2">\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;">\n' +
                '                                        <li class="letter-header" id="M">M</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="N">N</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="O">O</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="P">P</li>\n' +
                '\n' +
                '                                    </ul>\n' +
                '\n' +
                '                                </div>\n' +
                '                                <div class="col-md-2">\n' +
                '\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;">\n' +
                '\n' +
                '\n' +
                '                                        <li class="letter-header" id="Q">Q</li>\n' +
                '                                        \n' +
                '                                        <li class="letter-header" id="R">R</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="S">S</li>\n' +
                '                                        \n' +
                '                                        <li class="letter-header" id="T">T</li>\n' +
                '                                        \n' +
                '                                    </ul>\n' +
                '                                </div>\n' +
                '                                <div class="col-md-2">\n' +
                '                                    <ul class="list-unstyled" style="margin-bottom: 0px;">\n' +
                '\n' +
                '\n' +
                '                                        <li class="letter-header" id="U">U</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="V">V</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="W">W</li>\n' +
                '\n' +
                '                                        <li class="letter-header" id="X">X</li>\n' +
                '\n' +
                '                                       \n' +
                '                                        <li class="letter-header" id="Y">Y</li>\n' +
                '                                       \n' +
                '                                        <li class="letter-header" id="Z">Z</li>\n' +
                '                                      \n' +
                '\n' +
                '                                    </ul>\n' +
                '                                </div>\n' +
                '                            </div>\n' +
                '                            <div class="clearfix"></div>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>';

            $("#tabContent"+teamId).append(directoryList);
        }



        //向当前哪一个部门tab视图,传递对应的字典列表,对应字典,插入的字典列表位置
        function insertProjectNode(teamId,data,dierctory,currentPosition) {
            //面向当前视图id.切换到部门tab下的标签内容,tabContent
            checkMainPage(data[Object.keys(data)[currentPosition]][0].teamProjectName);
            //定位只有一个视图时候的html的项目字典序
            var item = "<li><a href='javascript:void(0)" +"'"+
                "title='"+data[Object.keys(data)[currentPosition]][0].teamProjectDescrption+ "'data-value='"+data[Object.keys(data)[currentPosition]][0].teamProjectId
                +"'>" + data[Object.keys(data)[currentPosition]][0].teamProjectName+"</a></li>";
            // var item_tags = document.getElementById(dierctory);
            var item_tags = $("#tabContent"+teamId).find(".letter-header")[dierctory.charCodeAt()-65];

            $(item).insertAfter(item_tags);
        }


        function checkMainPage(result) {

            if (result == null) {
                result = "#"
            }


        }


    }



});


