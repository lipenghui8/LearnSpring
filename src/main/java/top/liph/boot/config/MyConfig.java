package top.liph.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.liph.boot.bean.Pet;
import top.liph.boot.bean.User;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:32
 * 配置类中使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * proxyBeanMethods:代理Bean的方法，默认为true
 **/
@Configuration //告诉springboot这是一个配置类,等同于配置文件
public class MyConfig {

    @Bean//给容器添加组件，以方法名作为组件ID，返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01(){
        return new User("zhangsan",18);
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
