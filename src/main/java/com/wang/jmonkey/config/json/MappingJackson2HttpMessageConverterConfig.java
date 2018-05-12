package com.wang.jmonkey.config.json;

import com.wang.jmonkey.config.json.mapper.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 将Jackson2HttpMessageConverter的默认格式化输出为false
 * @Auther: HeJiawang
 * @Date: 2018/5/12
 */
@Configuration
public class MappingJackson2HttpMessageConverterConfig {

    @Bean
    public MappingJackson2HttpMessageConverter config(){
        MappingJackson2HttpMessageConverter config = new MappingJackson2HttpMessageConverter();

        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        config.setSupportedMediaTypes(supportedMediaTypes);

        config.setPrettyPrint(false);

        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.setDateFormat( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        config.setObjectMapper(jsonMapper);

        return config;
    }
}
