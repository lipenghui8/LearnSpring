package top.liph.springbootweb.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Mr.Li
 * @create: 2022-04-15 21:20
 **/
@Controller
public class HelloWorld {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
