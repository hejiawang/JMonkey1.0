package com.wang.jmonkey.modules.test.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.modules.test.entity.Test;
import com.wang.jmonkey.modules.test.service.ITestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/4/12
 */
@RestController
@RequestMapping("/test/test")
public class TestRestApi extends BaseHttp {

    @Resource
    private ITestService testService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Test list(){
        return testService.selectById("12123");
    }
}
