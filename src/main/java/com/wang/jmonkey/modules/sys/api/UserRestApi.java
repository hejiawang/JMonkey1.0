package com.wang.jmonkey.modules.sys.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.modules.sys.entity.UserEntity;
import com.wang.jmonkey.modules.sys.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 用户管理
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@RestController
@RequestMapping("/sys/user")
public class UserRestApi extends BaseHttp {

    @Resource
    private IUserService userService;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list( UserEntity user ){


        return "";
    }
}
