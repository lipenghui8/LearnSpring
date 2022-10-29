package top.liph.springsecurityweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.liph.springsecurityweb.mapper")
public class SpringSecurityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWebApplication.class, args);
    }

}
