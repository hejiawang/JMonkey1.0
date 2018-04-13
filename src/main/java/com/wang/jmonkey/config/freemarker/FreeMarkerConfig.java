package com.wang.jmonkey.config.freemarker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: FreeMarker Config
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Configuration
public class FreeMarkerConfig {

    @Value("${jMonkey.freemarker.templateLoaderPath}")
    private String templateLoaderPath;

    @Value("${jMonkey.freemarker.freemarkerSettings.template_update_delay}")
    private String templateUpdateDelay;

    @Value("${jMonkey.freemarker.freemarkerSettings.default_encoding}")
    private String defaultEncoding;

    @Value("${jMonkey.freemarker.freemarkerSettings.locale}")
    private String locale;

    @Value("${jMonkey.freemarker.freemarkerSettings.datetime_format}")
    private String datetimeFormat;

    @Value("${jMonkey.freemarker.freemarkerSettings.time_format}")
    private String timeFormat;

    @Value("${jMonkey.freemarker.freemarkerSettings.number_format}")
    private String numberFormat;

    @Value("${jMonkey.freemarker.freemarkerSettings.boolean_format}")
    private String booleanFormat;

    @Value("${jMonkey.freemarker.freemarkerSettings.whitespace_stripping}")
    private String whitespaceStripping;

    @Value("${jMonkey.freemarker.freemarkerSettings.tag_syntax}")
    private String tagSyntax;

    @Value("${jMonkey.freemarker.freemarkerSettings.url_escaping_charset}")
    private String urlEscapingCharset;

    @Value("${jMonkey.freemarker.freemarkerVariables.webURL}")
    private String webURL;

    @Value("${jMonkey.freemarker.freemarkerVariables.cssURL}")
    private String cssURL;

    @Value("${jMonkey.freemarker.freemarkerVariables.libURL}")
    private String libURL;

    @Value("${jMonkey.freemarker.freemarkerVariables.imagesURL}")
    private String imagesURL;

    @Value("${jMonkey.freemarker.freemarkerVariables.scriptsURL}")
    private String scriptsURL;

    @Value("${jMonkey.freemarker.freemarkerVariables.min}")
    private String min;

    @Value("${jMonkey.freemarker.freemarkerVariables.systemName}")
    private String systemName;

    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        this.setTemplateLoaderPath();
        this.setFreemarkerSettings();
        this.setFreemarkerVariables();

        return freeMarkerConfigurer;
    }

    /**
     * 设置Freemarker 模板位置
     */
    private void setTemplateLoaderPath(){
        freeMarkerConfigurer.setTemplateLoaderPath(this.templateLoaderPath);
    }

    /**
     * 设置Freemarker环境属性
     */
    private void setFreemarkerSettings(){
        Properties settings = new Properties();

        settings.setProperty("template_update_delay", this.templateUpdateDelay);
        settings.setProperty("default_encoding", this.defaultEncoding);
        settings.setProperty("locale", this.locale);
        settings.setProperty("datetime_format", this.datetimeFormat);
        settings.setProperty("time_format", this.timeFormat);
        settings.setProperty("number_format", this.numberFormat);
        settings.setProperty("boolean_format", this.booleanFormat);
        settings.setProperty("whitespace_stripping", this.whitespaceStripping);
        settings.setProperty("tag_syntax", this.tagSyntax);
        settings.setProperty("url_escaping_charset", this.urlEscapingCharset);

        freeMarkerConfigurer.setFreemarkerSettings(settings);
    }

    /**
     * 设置Freemarker自定义变量
     */
    private void setFreemarkerVariables(){
        Map<String, Object> variables = new HashMap<>();
        variables.put("webURL", this.webURL);
        variables.put("cssURL", this.cssURL);
        variables.put("libURL", this.libURL);
        variables.put("imagesURL", this.imagesURL);
        variables.put("scriptsURL", this.scriptsURL);
        variables.put("min", this.min);
        variables.put("systemName", this.systemName);

        freeMarkerConfigurer.setFreemarkerVariables(variables);
    }
}
