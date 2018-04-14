package com.wang.jmonkey.common.http.result;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: Http分页数据统计返回结果对象
 * @Auther: HeJiawang
 * @Date: 2018/4/14
 */
@Data
@Accessors(chain = true)
public class HttpPageResult<T> {

    private List<T> rows;
    private int code;
    private String message;
    private int pageIndex;
    private int pageSize;
    private long total;

    public HttpPageResult (Page<T> page) {
        this.code = 0;
        this.rows = page.getRecords();
        this.total = page.getTotal();
        this.pageIndex = page.getCurrent();
        this.pageSize = page.getSize();

    }

    public void error (int code, String message) {
        this.code = code;
        this.message = message;
    }


}
