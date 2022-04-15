package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Mr.Li
 * @create: 2022-04-15 20:39
 **/

@Controller
public class RequestController {


    @GetMapping("/got")
    public String got(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public String success(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code){
        return null;
    }
}
