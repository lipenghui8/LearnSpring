package com.liph.boot.controller;

import com.liph.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author: Mr.Li
 * @create: 2022-10-06 19:21
 **/
@Controller
public class indexController {

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
        Object loginUser=session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else{
            return "login";
        }

    }
}
