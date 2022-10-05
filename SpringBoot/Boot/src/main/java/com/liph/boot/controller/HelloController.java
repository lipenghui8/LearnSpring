package com.liph.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.Li
 * @create: 2022-10-05 21:11
 **/
@RestController
public class HelloController {
    @RequestMapping
    public String hello(){
        return "你好！";
    }
}
