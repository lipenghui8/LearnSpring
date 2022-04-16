package com.liph.managementsystem.managementsystem.controller;

import com.liph.managementsystem.managementsystem.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Mr.Li
 * @create: 2022-04-15 21:57
 **/
@Controller
public class IndexController {
    /**
     * 登录页
     * @return
     */
    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!user.getUsername().isEmpty()&&!user.getPassword().isEmpty()){
            //登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功，重定向防止表单重复提交
            return "redirect:/main";
        }else{
            model.addAttribute("msg","账号密码错误");
            //回到登录页
            return "login";
        }
    }

    @GetMapping("/main")
    public String mainPage(HttpSession session,Model model){
        Object loginUser=session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else{
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }
}
