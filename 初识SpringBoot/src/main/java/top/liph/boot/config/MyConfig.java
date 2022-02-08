package top.liph.boot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.liph.boot.bean.Car;
import top.liph.boot.bean.Pet;
import top.liph.boot.bean.User;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:32
 * 1.配置类中使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理Bean的方法，默认为true,如果别人不依赖注册的组件，一般设置为false
 * 4.Import给容器中自动创建类型的组件
 * 5.@ConditionalOnXXX 条件装配
 * 6.ImportResource(“”)导入Spring的配置文件
 **/
@Import({User.class, DBHelper.class}) //使用Import导入组件
@Configuration(proxyBeanMethods = false) //告诉springboot这是一个配置类,等同于配置文件

//1.开启Car的配置绑定功能
//2.把Car这个组件自动注册到容器中，可以用来替代@Component
@EnableConfigurationProperties({Car.class})

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
