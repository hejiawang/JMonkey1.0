var PageAction = function () {

}

$.extend(PageAction.prototype, {
    /**
     * 初始化操作
     */
    'init' : function () {
        this.initTable();
    },
    /**
     * 初始化表格数据
     */
    'initTable' : function () {
        var _t = this;

        $('#userTable').bootstrapTable({
            url: webURL + "/sys/user/list",
            contentType: "application/x-www-form-urlencoded",
            clickToSelect: true,                //设置 true 将在点击行时，自动选择 rediobox 和 checkbox。
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            sidePagination: "server",//分页方式：client客户端分页，server服务端分页
            queryParams : function(params) {
                var paramsData = {};
                //paramsData['pageSize'] = params.limit;
                //paramsData['pageIndex'] = (params.offset / params.limit) + 1;

                paramsData.size = params.limit;
                paramsData.current = (params.offset / params.limit) + 1;

                console.info(paramsData);

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

    'save' : function (o) {
        var _t = this;

        layer.open({
            type: 2,
            area: ['100%', '100%'],
            content: webURL + "/page/sys/user/save_or_modify.html",
            btn: ["确定", "取消"],
            success: function ( layero, index ) {
                var win = $(layero).find("iframe")[0].contentWindow,
                    $dom = $(win.document),
                    $form = $dom.find('form');

                var formValidate = $form.validate();

                $form.on('submit', function (e) {
                    if (formValidate.valid()) {
                        $.ajax({
                            url: webURL + "/sys/user/save",
                            data: JSON.stringify( _t.serializeObject($form)),
                            type: 'post',
                            dataType: 'json',
                            contentType: 'application/json;charset=utf-8',
                            success: function ( result ) {
                                alert('success');
                            },
                            error: function ( result ) {
                                alert('error');
                            }
                        });
                    }

                    return false;
                });
            },
            yes: function ( index, layero ) {
                var dom = $(layero).find("iframe")[0].contentWindow.document,
                    $dom = $(dom),
                    $form = $dom.find('form');

                $form.trigger('submit');
            },
        });
    },
    'delete' : function (o) {
        alert('delete');
    },
    'modify' : function (o) {
        alert('modify');
    },
    'detail' : function (o) {
        alert('detail');
    },
    'serializeObject' : function (ser) {
        var o = {};
        var arr = ser.serializeArray();
        $.each(arr, function() {
            if (/(\w+)\.(\w+)/.test(this.name)) {
                var key = RegExp.$1;
                var ikey = RegExp.$2;
                o[key] = o[key] || {};
                o[key][ikey] = this.value;
            }else if (/(\w+)\[(\w+)\]/.test(this.name)) {
                var key = RegExp.$1;
                var ikey = RegExp.$2;
                o[key] = o[key] || [];
                var jo = {};
                jo[ikey] = this.value;
                o[key].push(jo);
            } else {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            }
        });
        return o;
    }
});

$(function () {
    var pageAction = new PageAction();
    pageAction.init();
});