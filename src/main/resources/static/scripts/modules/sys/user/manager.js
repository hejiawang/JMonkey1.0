var PageAction = function () {

}

$.extend(PageAction.prototype, {
    /**
     * 初始化操作
     */
    'init' : function () {
        this.initTable();
        //this.initBtnLinstener();
    },
    /**
     * 初始化表格数据
     */
    'initTable' : function () {
        var _t = this;

        $('#userTable').bootstrapTable({
            url: webURL + "/sys/user/list",
            contentType: "application/x-www-form-urlencoded",
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            sidePagination: "server",//分页方式：client客户端分页，server服务端分页
            queryParams : function(params) {
                var paramsData = {};
                if (paramsData) {
                    paramsData['pageSize'] = params.limit;
                    paramsData['pageIndex'] = (params.offset / params.limit) + 1;
                }
                return paramsData;
            },
            onLoadSuccess : function () {
                $('.rabbit-table-btn').on('click', function(){
                    var type = $(this).attr('table-event');
                    type && _t[type] && _t[type](this);
                });
            }
        });

        _t.resetTableView();
        $(window).on('resize', _t.resetTableView());
    },
    /**
     * 重置表格样式
     */
    'resetTableView' : function () {
        $('#userTable').bootstrapTable('resetView', {
            height: $(window).height() - 110
        });
    },

    'btnHandler' : function () {
        var _t = this;

        $('.rabbit-table-btn').on('click', function(){
            var type = $(this).attr('table-event');
            type && _t[type] && _t[type](this);
        });
    },
    'initBtnLinstener' : function () {
        var _t = this;

        $('.rabbit-table-btn').on('click', function(){
            var type = $(this).attr('table-event');
            type && _t[type] && _t[type](this);
        });
    },
    'save' : function (o) {
        alert('save');
    },
    'delete' : function (o) {
        alert('delete');
    },
    'modify' : function (o) {
        alert('modify');
    },
    'detail' : function () {
        alert('detail');
    }
});

$(function () {
    var pageAction = new PageAction();
    pageAction.init();
});