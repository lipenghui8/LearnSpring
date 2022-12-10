package com.daheremark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.daheremark.mapper")
@SpringBootApplication
public class daheremarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(daheremarkApplication.class, args);
    }

}
