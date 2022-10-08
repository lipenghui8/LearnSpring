package com.liph.boot.controller;

import com.liph.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr.Li
 * @create: 2022-10-06 20:12
 **/
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){

        List<User> users= Arrays.asList(new User("zhansan","1234"),
                new User("lisi","aaaaaa"),
                new User("penghui","88888"),
                new User("wangwu","777777"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
