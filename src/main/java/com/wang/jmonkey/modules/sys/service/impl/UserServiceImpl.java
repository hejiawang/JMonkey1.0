package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.sys.entity.UserEntity;
import com.wang.jmonkey.modules.sys.mapper.UserMapper;
import com.wang.jmonkey.modules.sys.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description: user service impl
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService{

}
