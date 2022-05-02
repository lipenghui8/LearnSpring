package com.liph.managementsystem.managementsystem.config;

import com.liph.managementsystem.managementsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Mr.Li
 * @create: 2022-05-02 16:45
 **/
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");//放行的请求
    }
}
