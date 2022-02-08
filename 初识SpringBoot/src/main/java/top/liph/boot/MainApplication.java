package top.liph.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 17:31
 **/
@SpringBootApplication
public class MainApplication {

    //直接运行main函数即可启动项目
    public static void main(String[] args){
        SpringApplication.run(MainApplication.class,args);
    }
}
