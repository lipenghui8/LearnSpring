package com.liph.managementsystem.managementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: Mr.Li
 * @create: 2022-04-15 21:57
 **/
@Controller
public class indexController {
    /**
     * 登录页
     * @return
     */
    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(String username,String password){

    }
}
