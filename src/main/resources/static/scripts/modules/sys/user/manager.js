$(function () {
    $('#userTable').bootstrapTable({
        method: 'get',
        dataType: "json",                   //类型json
        contentType: "application/x-www-form-urlencoded",
        showRefresh: false,                 //显示刷新按钮
        showToggle: false,                  //显示切换手机试图按钮
        showColumns: false,                 //显示 内容列下拉框
        showExport: false,                  //显示导出按钮
        showPaginationSwitch: false,        //显示切换分页按钮
        minimumCountColumns: 2,             //最低显示2行
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortOrder: "asc",                   //排序方式
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        url: webURL + "/sys/user/list",     //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        //queryParamsType:'',               //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        queryParams : function(params) {    //查询参数,每次调用是会带上这个参数，可自定义
            var paramsData = {};
            if (paramsData) {
                paramsData['pageSize'] = params.limit;
                paramsData['pageIndex'] = (params.offset / params.limit) + 1;
            }
            return paramsData;
        },
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contextMenuTrigger:"right",//pc端 按右键弹出菜单
        contextMenuTriggerMobile:"press",//手机端 弹出菜单，click：单击， press：长按。
        contextMenu: '#context-menu',
        onContextMenuItem: function(row, $el){
        },
        onClickRow: function(row, $el){
        },
    });
});