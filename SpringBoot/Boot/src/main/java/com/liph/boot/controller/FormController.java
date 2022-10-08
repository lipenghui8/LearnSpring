package com.liph.boot.controller;

import lombok.extern.slf4j.Slf4j;
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
 * @create: 2022-10-08 12:21
 **/
@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layout(){

        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：photos={}",photos.length);

        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\cache\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\cache\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
