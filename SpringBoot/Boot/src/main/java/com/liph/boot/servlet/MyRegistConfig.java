package com.liph.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author: Mr.Li
 * @create: 2022-10-08 13:37
 **/

@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServletImpl myServletImpl =new MyServletImpl();
        return new ServletRegistrationBean(myServletImpl,"/my","/my01");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter=new MyFilter();
        FilterRegistrationBean myFilterRegistrationBean = new FilterRegistrationBean(myFilter);
        myFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return myFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }
}
