package top.liph.springsecurityweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lipenghui
 * @create: 2022-10-29 22
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String add(){
        return "hello security";
    }

    @GetMapping("index")
    public String index(){
        return "hello index";
    }


}
