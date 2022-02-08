package top.liph.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.liph.boot.bean.Car;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 17:35
 **/
@Slf4j
@RestController
public class HelloController {

    @Autowired//自动注入
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        log.info("请求进来了。。。");
        return "HelloSpringBoot";
    }
}
