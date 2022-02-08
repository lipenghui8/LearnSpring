package top.liph.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 19:46
 * 只有在容器中的组件才会有springboot提供的强大功能
 **/
@ToString
@Data
@Component //将组件添加到容器中
@ConfigurationProperties(prefix = "mycar")//配置绑定
public class Car {
    private String brand;
    private Integer price;
}
