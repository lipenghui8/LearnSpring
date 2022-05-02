package com.liph.managementsystem.managementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: Mr.Li
 * @create: 2022-05-02 17:17
 **/
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String from_layouts(){
        return "form/form_layouts";
    }

    /**
     * 自动封装上传的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        if(!headerImg.isEmpty()){
            //保存到文件服务器
            String name=headerImg.getOriginalFilename();
            headerImg.transferTo(new File("C:\\Downloads\\admin\\images\\upload\\"+name));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String name=photo.getOriginalFilename();
                    photo.transferTo(new File("C:\\Downloads\\admin\\images\\upload\\"+name));
                }
            }
        }

        return "main";
    }
}
