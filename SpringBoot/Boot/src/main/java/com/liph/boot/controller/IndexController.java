package com.liph.boot.controller;

import com.liph.boot.bean.Account;
import com.liph.boot.bean.City;
import com.liph.boot.bean.User;
import com.liph.boot.service.AccountService;
import com.liph.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author: Mr.Li
 * @create: 2022-10-06 19:21
 **/
@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        //登录成功，重定向，防止表单重复提交
        if(Objects.equals(user.getUserName(), "admin") && Objects.equals(user.getPassword(), "admin")){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号或密码错误！");
            return "login";
        }
    }

    @GetMapping("main.html")

    public String mainPage(HttpSession session){
        return "main";
    }

    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){

        return accountService.getAcctById(id);
    }

    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCity(@RequestParam("id") Long id){
        return cityService.getById(id);
    }
}
