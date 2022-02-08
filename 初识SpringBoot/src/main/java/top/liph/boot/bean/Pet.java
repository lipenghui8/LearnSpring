package top.liph.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:39
 **/
@ToString
@Data
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
public class Pet {
    private String name;
}
