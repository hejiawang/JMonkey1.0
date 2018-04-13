package com.wang.jmonkey.common.http.abs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Description: 基础控制器
 * @Auther: HeJiawang
 * @Date: 2018/04/11
 */
public abstract class BaseHttp {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 参数统一处理
     * @param model
     */
    protected void paramsHandler(Model model) {
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String value = request.getParameter(name);
            model.addAttribute(name, value);
        }
    }
}
