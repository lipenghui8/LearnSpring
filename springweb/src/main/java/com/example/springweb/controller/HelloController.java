package com.example.springweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.Li
 * @create: 2022-02-09 17:57
 **/
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @RequestMapping("/eror")
    public String error(){
        return "none";
    }
}
