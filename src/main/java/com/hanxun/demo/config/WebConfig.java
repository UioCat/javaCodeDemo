package com.hanxun.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author han xun
 * Date 2021-10-08 14:42
 * Description 跨域配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")// 所有的当前站点的请求地址，都支持跨域访问。
            .allowedMethods("GET", "POST", "PUT", "DELETE") // 当前站点支持的跨域请求类型是什么。
            .allowCredentials(true) // 是否支持跨域用户凭证
            .allowedOriginPatterns("*") // 所有的外部域都可跨域访问。 如果是localhost则很难配置，因为在跨域请求的时候，外部域的解析可能是localhost、127.0.0.1、主机名
            .maxAge(3600); // 超时时长设置为1小时。 时间单位是秒。
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
}
