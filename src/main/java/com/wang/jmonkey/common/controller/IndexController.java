package com.wang.jmonkey.common.controller;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 首页路径
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseHttp {

    @RequestMapping(value = {"", "/index", "/index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
