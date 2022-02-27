package com.example.springweb.config;

import com.example.springweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Mr.Li
 * @create: 2022-02-27 16:58
 * 用来定制SpringMVC的一些功能
 **/
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截谁
                .excludePathPatterns("/","/login");  //放行谁
    }
}
