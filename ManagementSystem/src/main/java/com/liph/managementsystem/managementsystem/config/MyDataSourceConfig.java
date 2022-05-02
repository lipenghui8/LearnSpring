package com.liph.managementsystem.managementsystem.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Mr.Li
 * @create: 2022-05-02 18:21
 **/
@Configuration
public class MyDataSourceConfig {
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();

        return druidDataSource;
    }
}
