package com.wang.jmonkey.common.controller;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.constants.HttpConsts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 模块页面请求
 * @Auther: HeJiawang
 * @Date: 2018/04/11
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseHttp {

    /**
     * 统一模版跳转控制
     * @param views
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/{views}/{page}.html", method = RequestMethod.GET)
    public String page (@PathVariable("views") String views, @PathVariable("page") String page, Model model) {
        super.paramsHandler(model);
        return new StringBuilder(HttpConsts.VIEW_BASE).append(views).append(HttpConsts.URI_SEPARATOR).append(page).toString();
    }
}
