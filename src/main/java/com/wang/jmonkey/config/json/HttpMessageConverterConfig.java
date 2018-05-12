package com.wang.jmonkey.config.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * @Description: 将StringHttpMessageConverter的默认编码设为UTF-8
 * @Auther: Hejiawang
 * @Date: 2018/5/12
 */
@Configuration
public class HttpMessageConverterConfig {

    @Bean
    public StringHttpMessageConverter config(){
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
