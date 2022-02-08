package top.liph.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:33
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
}
