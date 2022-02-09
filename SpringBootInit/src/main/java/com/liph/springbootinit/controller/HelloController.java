package com.liph.springbootinit.controller;

import com.liph.springbootinit.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.Li
 * @create: 2022-02-09 11:45
 **/
@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }

}
