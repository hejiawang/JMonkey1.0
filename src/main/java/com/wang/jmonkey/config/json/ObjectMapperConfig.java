package com.wang.jmonkey.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 初始化ObjectMapper
 * @Auther: HeJiawang
 * @Date: 2018/5/12
 */
//@Configuration
public class ObjectMapperConfig {

    //@Bean
    public ObjectMapper ObjectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        return objectMapper;
    }
}
