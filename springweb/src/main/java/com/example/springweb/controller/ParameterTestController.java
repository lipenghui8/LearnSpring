package com.example.springweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Mr.Li
 * @create: 2022-04-15 20:00
 **/
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        return map;
    }
}
