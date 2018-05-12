package com.wang.jmonkey.common.http.result;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: HTTP控制器返回结果对象
 * @Auther: HeJiawang
 * @Date: 2018/4/14
 */
@Data
@Accessors(chain = true)
public class HttpControllerResult<T>  {

    private T result;
    private int code;
    private String message;
    private Boolean isSuccess = true;

    public HttpControllerResult () {}

    public HttpControllerResult (T t) {
        this.code = 0;
        this.isSuccess = true;
        this.result = t;
    }

    public HttpControllerResult<T> error (int code, String message) {
        this.code = code;
        this.isSuccess = false;
        this.message = message;
        return this;
    }
}
