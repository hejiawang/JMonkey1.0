package com.wang.jmonkey.modules.sys.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpControllerResult;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.modules.sys.entity.UserEntity;
import com.wang.jmonkey.modules.sys.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

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
    public HttpPageResult<UserEntity> list(Page<UserEntity> page, UserEntity user ){
        EntityWrapper<UserEntity> userWrapper = new EntityWrapper<>();
        userWrapper.setEntity(user);
        userWrapper.orderAsc(Arrays.asList(new String[]{"create_date"}));

        return new HttpPageResult<>(userService.selectPage(page, userWrapper));
    }

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public HttpControllerResult<Void> save(@RequestBody UserEntity user) {
        userService.insert(user);
        return new HttpControllerResult<>();
    }
}
