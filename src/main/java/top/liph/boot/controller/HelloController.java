package top.liph.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 17:35
 **/
@ResponseBody
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "HelloSpringBoot";
    }
}
