$(function () {

    //所有发生在主页的响应事件
    tabChange();

    var api = {
        projectId: document.getElementById("projectDetail").dataset.value,
        page: {
            current: 1,
            size: 7,
            total: 0
        },
        // 获取一页 bug
        getList: function (type, cb) {
            var page = this.page
            var current

            switch (type) {
                case 'init':
                    current = 1
                    break
                case 'pre':
                    current = page.current - 1
                    break
                case 'next':
                    current = page.current + 1
                    break
            }

            $.ajax({
                method: 'post',
                url: '/project/selectBugCommitByPageHelper/' + this.projectId,
                data: JSON.stringify({
                    pageNum: current,
                    pageSize: page.size
                }),
                dataType: "json",
                contentType: 'application/json',
                success: function (res) {
                    var data = res.data.bugCommitRecord
                    if (res.status === 0) {
                        page.current = data.pageNum
                        page.total = data.total

                        cb(data.list, page)
                    } else {
                        alert(res.msg)
                    }
                }
            })
        },

        create: function (newBugData, cb) {
            $.ajax({
                method: 'post',
                url: '/project/createBugCommitByTeamProjectId/' + this.projectId,
                dataType: "json",
                contentType: 'application/json',
                data: JSON.stringify(newBugData),
                success: function (res) {
                    cb(res)
                }
            })
        },

        // update bug
        updateBug: function (newBugData, cb) {
            $.ajax({
                method: 'post',
                url: '/project/editorBugCommitBugByTeamProjectId/' + this.projectId,
                data: JSON.stringify(newBugData),
                success: function (res) {
                    cb(res.data)
                }
            })
        }
    };


    var recordApi = {
        projectId: "www.baidu.com",
        page: {
            current: 1,
            size: 7,
            total: 0
        },
        getList: function (type, cb) {
            var page = this.page
            var current

            switch (type) {
                case 'init':
                    current = 1
                    break
                case 'pre':
                    current = page.current - 1
                    break
                case 'next':
                    current = page.current + 1
                    break
            }

            $.ajax({
                method: 'post',
                url: '/project/selectCodeRecordByTeamProjectId/' + this.projectId,
                data: JSON.stringify({
                    pageNum: current,
                    pageSize: page.size
                }),
                dataType: "json",
                contentType: 'application/json',
                success: function (res) {
                    var data = res.data;
                    if (res.status === 0) {
                        page.current = res.pageNum;
                        page.total = res.total;

                        cb(data, page)
                    } else {
                        alert(res.msg)
                    }
                }
            })
        }
    }


    function tabChange() {
        $("body").on('click', '#projectItemNav li', function () {

            $("#projectDetail").empty();

            $(' #projectList').hide();

            var projectId = document.getElementById("projectDetail").getAttribute("value");


            var _id = $(this).attr('data-type');

            switch (_id) {
                case "1":
                    fillProjectDocument(projectId, _id);
                    break;
                case "2":
                    fillProjectDocument(projectId, _id);
                    break;
                case "3":
                    fillProjectDocument(projectId, _id);
                    break;
                case "4":
                    fillProjectCodeRecord(projectId);
                    break;
                case "5":
                    fillProjectBugCommit(projectId);
                    break;
            }


        })
    }


    function fillProjectDocument(teamId, documentType) {
        $.ajax({
            url: "../project/selectDocumentByTeamProjectId/" + documentType + "/" + teamId,
            type: "post",
            traditional: true,
            success: function (result) {


                var editormd = '<div class="panel-body">\n' +
                    '            <div class="row">\n' +
                    '                <div id="my-editormd-preview" class="content editormd-preview-theme" style="width: 90%; height: 640px;">\n' +
                    result.data.documentContent +
                    '                </div>\n' +
                    '                    <button class="button button-highlight button-pill button-large btn-project-preview" >编辑内容</button>\n' +
                    '            </div>\n' +
                    '        </div>';

                var projectCharge = '负责人： ' + result.data.documentProjectCharge;

                $(' #projectDetail').append(editormd);
                $(" #projectDetail").show();

                $(".footer").empty();
                $(".footer").append(projectCharge);
            }


        });
    }

    function fillProjectCodeRecord(teamId) {

        ViewCodeRecord();
        recordApi.projectId = teamId;
        recordApi.getList('init', function (list) {
            store.list = list.slice()
            renderCodeRecordList(list)
            disableCodeRecord('pre')

        })
    }

    //代码发布记录分页内容
    $('.code-prePage, .code-nextPage').click(function () {
        var $this = $(this)
        var pageType = $this.data('type')

        api.getList(pageType, function (list, page) {
            store.list = list.slice()
            renderCardList(list)

            if (page.current === 1) {
                disablePagination('pre')
            }

            if (page.current <= page.total / page.size) {
                disablePagination('next')
            }
        })
    });


    function ViewCodeRecord() {
        var codeRecordList = '<ul class="timeline">\n' +
            '        <li>\n' +
            '            <div class="timeline-panel">\n' +
            '                <div class="time-heading">\n' +
            '                <h4 class="timeline-title">icedesign</h4>\n' +
            '                <p><small class="text-muted"><i class="glyphicon glyphicon-time"></i> 11 hours ago via Twitter</small></p>\n' +
            '                <div>\n' +
            '                    <ul class="list-style-none f6">\n' +
            '\n' +
            '                        <li class="d-inline-block mt-1 mr-2 text-mono">\n' +
            '                            <a class="muted-link" href="/alibaba/ice/commit/16dae35056272ac4c10e75dd2ec4928327895881">\n' +
            '                                <svg class="octicon octicon-git-commit" viewBox="0 0 14 16" version="1.1" width="14" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M10.86 7c-.45-1.72-2-3-3.86-3-1.86 0-3.41 1.28-3.86 3H0v2h3.14c.45 1.72 2 3 3.86 3 1.86 0 3.41-1.28 3.86-3H14V7h-3.14zM7 10.2c-1.22 0-2.2-.98-2.2-2.2 0-1.22.98-2.2 2.2-2.2 1.22 0 2.2.98 2.2 2.2 0 1.22-.98 2.2-2.2 2.2z"></path></svg>\n' +
            '                                16dae35\n' +
            '                            </a>\n' +
            '                        </li>\n' +
            '\n' +
            '                        <li class="d-inline-block mt-1 mr-2">\n' +
            '                            <a class="muted-link" href="/alibaba/ice/archive/@icedesign/step-form-block@0.1.1.zip" rel="nofollow">\n' +
            '                                <svg class="octicon octicon-file-zip" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.5 1H1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V4.5L8.5 1zM11 14H1V2h3v1h1V2h3l3 3v9zM5 4V3h1v1H5zM4 4h1v1H4V4zm1 2V5h1v1H5zM4 6h1v1H4V6zm1 2V7h1v1H5zM4 9.28A2 2 0 0 0 3 11v1h4v-1a2 2 0 0 0-2-2V8H4v1.28zM6 10v1H4v-1h2z"></path></svg>\n' +
            '                                zip\n' +
            '                            </a>\n' +
            '                        </li>\n' +
            '\n' +
            '                        <li class="d-inline-block mt-1 mr-2">\n' +
            '                            <a class="muted-link" href="/alibaba/ice/archive/@icedesign/step-form-block@0.1.1.tar.gz" rel="nofollow">\n' +
            '                                <svg class="octicon octicon-file-zip" viewBox="0 0 12 16" version="1.1" width="12" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M8.5 1H1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V4.5L8.5 1zM11 14H1V2h3v1h1V2h3l3 3v9zM5 4V3h1v1H5zM4 4h1v1H4V4zm1 2V5h1v1H5zM4 6h1v1H4V6zm1 2V7h1v1H5zM4 9.28A2 2 0 0 0 3 11v1h4v-1a2 2 0 0 0-2-2V8H4v1.28zM6 10v1H4v-1h2z"></path></svg>\n' +
            '                                tar.gz\n' +
            '                            </a>\n' +
            '                        </li>\n' +
            '\n' +
            '\n' +
            '                    </ul>\n' +
            '                </div>\n' +
            '                </div>\n' +
            '                <div class="timeline-body">\n' +
            '                    <p> update project redmine</p>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </li>\n' +
            '    </ul>\n' +
            '<footer>\n' +
            '      <ul class="pagination">\n' +
            '        <li class="page-item">\n' +
            '          <a class="page-link code-prePage" href="javascript:void(0);" data-type="pre">上一页</a>\n' +
            '        </li>\n' +
            '        <li class="page-item">\n' +
            '          <a class="page-link code-nextPage" href="javascript:void(0);" data-type="next">下一页</a>\n' +
            '        </li>\n' +
            '      </ul>\n' +
            '</footer>';
        $(" #projectDetail").empty();
        $(' #projectDetail').append(codeRecordList);

    }


    function fillProjectBugCommit(teamId) {

        ViewBugCommitRecord();

        api.projectId = teamId;
        api.getList('init', function (list) {
            store.list = list.slice()
            renderCardList(list)
            disablePagination('pre')
        })


    }


    function ViewBugCommitRecord() {


        var bugCommitScreen = '<div id="app">\n' +
            '      <div class="card js-card-template js-card" \n' +
            '      style="display: none; width: 100%; margin: 30px auto;">\n' +
            '        <div class="card-body">\n' +
            '          <h5 class="card-title js-card-title"></h5>\n' +
            '          <h6 class="card-subtitle mb-2 text-muted js-card-desc"></h6>\n' +
            '        </div>\n' +
            '        <ul class="list-group list-group-flush" style="font-size: 0.8em;">\n' +
            '          <li class="list-group-item">提交时间: <span class="js-card-submit-time"></span></li>\n' +
            '          <li class="list-group-item">提交人: <span class="js-card-submitter"></span></li>\n' +
            '        </ul>\n' +
            '        <div class="card-body">\n' +
            '          <a\n' +
            '            href="javascript:void(0)"\n' +
            '            data-toggle="modal"\n' +
            '            data-target=".js-detailModal"\n' +
            '            class="card-link btn btn-primary js-edit-btn"\n' +
            '            >修改</a\n' +
            '          >\n' +
            '        </div>\n' +
            '      </div>\n' +
            '      <button\n' +
            '        class="btn btn-lg btn-primary btn-new js-newBtn"\n' +
            '        data-toggle="modal"\n' +
            '        data-target=".js-detailModal"\n' +
            '      >新增</button>\n' +
            '    </div>\n' +
            '    <footer>\n' +
            '      <ul class="pagination">\n' +
            '        <li class="page-item">\n' +
            '          <a class="page-link js-prePage" href="javascript:void(0);" data-type="pre">上一页</a>\n' +
            '        </li>\n' +
            '        <li class="page-item">\n' +
            '          <a class="page-link js-nextPage" href="javascript:void(0);" data-type="next">下一页</a>\n' +
            '        </li>\n' +
            '      </ul>\n' +
            '    \n' +
            '    </footer>';

        var modal = ' <div class="modal js-detailModal" tabindex="-1" role="dialog">\n' +
            '        <div class="modal-dialog" role="document">\n' +
            '          <div class="modal-content">\n' +
            '            <div class="modal-header">\n' +
            '              <h5 class="modal-title">编辑项目</h5>\n' +
            '              <button\n' +
            '                type="button"\n' +
            '                class="close"\n' +
            '                data-dismiss="modal"\n' +
            '                aria-label="Close"\n' +
            '              >\n' +
            '                <span aria-hidden="true">&times;</span>\n' +
            '              </button>\n' +
            '            </div>\n' +
            '            <div class="modal-body">\n' +
            '              <form>\n' +
            '                <div class="form-group">\n' +
            '                  <label for="title">BUG 修复理由</label>\n' +
            '                  <input\n' +
            '                    class="form-control js-form-desc"\n' +
            '                    type="text"\n' +
            '                    placeholder="如，BUG 影响了什么功能"\n' +
            '                  />\n' +
            '                </div>\n' +
            '                <div class="form-group">\n' +
            '                  <label for="title">BUG 解决办法</label>\n' +
            '                  <textarea\n' +
            '                    class="form-control js-form-info"\n' +
            '                    type="text"\n' +
            '                  ></textarea>\n' +
            '                </div>\n' +
            '              </form>\n' +
            '            </div>\n' +
            '            <div class="modal-footer">\n' +
            '              <button\n' +
            '                type="button"\n' +
            '                class="btn btn-secondary"\n' +
            '                data-dismiss="modal"\n' +
            '              >\n' +
            '                取消\n' +
            '              </button>\n' +
            '              <button type="button" class="btn btn-primary js-save-btn" data-dismiss="modal">\n' +
            '                保存\n' +
            '              </button>\n' +
            '            </div>\n' +
            '          </div>\n' +
            '        </div>\n' +
            '      </div>';


        $(" #projectDetail").empty();

        $(" #projectDetail").append(bugCommitScreen);


        $(".js-detailModal").remove();
        $("body").append(modal);

    }

    $("body").on('click', '.js-save-btn', function () {
        var ProjectId = document.getElementById("projectDetail").getAttribute("value");
        api.projectId = ProjectId;
        var bugCommitReason = $(".js-form-desc").val();
        var bugCommitInfo = $(".js-form-info").val();

        var newBugData = {bugCommitReason: bugCommitReason, bugCommitInfo: bugCommitInfo};
        api.create(newBugData, function (result) {
            renderFormModal(result.data);
        })

    });

    //bug提交页面初始化试图渲染
    function renderBugCard(cardData) {
        var markup = $('.js-card-template')[0].outerHTML
        var $newCard = $(markup)
        var $titleEl = $newCard.find('.js-card-title')
        var $descEl = $newCard.find('.js-card-desc')
        var $timeEl = $newCard.find('.js-card-submit-time')
        var $submitterEl = $newCard.find('.js-card-submitter')
        var $editBtnEl = $newCard.find('.js-edit-btn')

        $newCard.removeClass('js-card-template')
        $newCard[0].dataset.id = cardData.bugCommitId
        $titleEl.text(cardData.bugCommitReason)
        $descEl.text(cardData.bugCommitInfo)
        $timeEl.text(cardData.createTime || cardData.updateTime)
        $submitterEl.text(cardData.bugCommitPerson)

        $newCard.show()
        $editBtnEl.on('click', function () {
            $editBtnEl.off('click')
            $editBtnEl.trigger('editStore:change', cardData)
        })

        return $newCard
    }

    function renderCodeRecord(codeRecordData) {
        var markup = $(".time-item")[0].outerHTML;
        var $newCard = $(markup);

        var $versionEl = $newCard.find('.timeline-title');
        var $commiterNameEl = $newCard.find('.timeline-commit-person');
        var $messageEl = $newCard.find('.timeline-body');
        var $commitDateEl = $newCard.find('.glyphicon-time');
        $newCard.removeClass('time-item');

        $versionEl.text(codeRecordData.recordCommitVersion);
        $commitDateEl.text(codeRecordData.recordCreateTime);
        $commiterNameEl.text(codeRecordData.recordCommitName);
        $messageEl.text(codeRecordData.recordCommitMessage);

        $newCard.show();

        return $newCard;
    }

    //代码发布记录初始化视图渲染
    function renderCodeRecordList(codeRecordList) {
        var $codeRecordList = $(".timeline");
        var $oldGroupContainer = $codeRecordList.children(".timeline-panel");
        var $groupContainer = $('<div class="timeline-panel"></div>');
        var $projectList = codeRecordList.map(renderCodeRecord);

        $oldGroupContainer.remove();
        $projectList.each(function (value) {
            $oldGroupContainer.append(value);
            $groupContainer.append($oldGroupContainer);
            $codeRecordList.append($groupContainer);
        })

    }

    function renderCardList(cardList) {
        var $container = $('#app')
        var $oldGroupContainer = $container.children('.js-cardGroup')
        var $groupContainer = $('<div class="js-cardGroup"></div>')
        var $cardElList = cardList.map(renderBugCard)

        $oldGroupContainer.remove()
        $cardElList.forEach(function ($el) {
            $groupContainer.append($el)
        })

        $container.append($groupContainer)
    }

    function renderFormModal(cardData, onSave) {
        var $model = $('.js-detailModal')
        var $descEl = $model.find('.js-form-desc')
        var $infoEl = $model.find('.js-form-info')

        $descEl.val(cardData.bugCommitReason || '')
        $infoEl.val(cardData.bugCommitInfo || '')

        var $saveBtn = $model.find('.js-save-btn')
        $saveBtn.one('click', function () {
            var bugCommitReason = $descEl.val()
            var bugCommitInfo = $infoEl.val()
            onSave(Object.assign({}, cardData, {
                bugCommitReason: bugCommitReason,
                bugCommitInfo: bugCommitInfo
            }))

            $descEl.val('')
            $infoEl.val('')
        })
    }

    function findCardDataViaId(id, list) {
        var cardList = list.filter(function (item) {
            return item.bugCommitId === id
        })

        return cardList[0]
    }

    function disablePagination(type) {
        switch (type) {
            case 'pre':
                $('.js-prePage').addClass('disable')
                $('.js-nextPage').removeClass('disable')
                break
            case 'next':
                $('.js-prePage').removeClass('disable')
                $('.js-nextPage').addClass('disable')
                break
        }
    }

    function disableCodeRecord(type) {
        switch (type) {
            case 'pre':
                $('.js-prePage').addClass('disable')
                $('.js-nextPage').removeClass('disable')
                break
            case 'next':
                $('.js-prePage').removeClass('disable')
                $('.js-nextPage').addClass('disable')
                break
        }
    }

    const store = {
        list: []
    }

    $('body').on('editStore:change', function (evt, cardData) {
        var isNew = cardData.isNew
        var req

        if (isNew) {
            delete cardData.isNew
            req = api.create
        } else {
            req = api.updateBug
        }
        renderFormModal(cardData, function (newCardData) {
            req.call(api, newCardData, function (newBugData) {
                if (isNew) {
                    store.list.push(newBugData)
                } else {
                    Object.assign(oldCardData, newBugData)
                }
                renderCardList(store.list)
            })

            $('.js-detailModal').modal('hide')
        })
    })

    $('.js-newBtn').click(function () {
        $('.js-newBtn').trigger('editStore:change', {
            isNew: true
        })
    })

    $('.js-prePage, .js-nextPage').click(function () {
        var $this = $(this)
        var pageType = $this.data('type')

        api.getList(pageType, function (list, page) {
            store.list = list.slice()
            renderCardList(list)

            if (page.current === 1) {
                disablePagination('pre')
            }

            if (page.current <= page.total / page.size) {
                disablePagination('next')
            }
        })
    })


});