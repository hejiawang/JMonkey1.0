package com.wang.jmonkey.modules.test.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.test.entity.Test;
import com.wang.jmonkey.modules.test.mapper.TestMapper;
import com.wang.jmonkey.modules.test.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/4/12
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
}
