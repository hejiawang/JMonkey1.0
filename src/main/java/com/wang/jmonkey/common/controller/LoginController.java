package com.wang.jmonkey.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 登录操作
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String index() {
        return "login";
    }
}
