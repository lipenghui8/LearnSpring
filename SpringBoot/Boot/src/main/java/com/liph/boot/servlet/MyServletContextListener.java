package com.liph.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: Mr.Li
 * @create: 2022-10-08 13:30
 **/
@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("初始化完成！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听到销毁！");
    }
}
