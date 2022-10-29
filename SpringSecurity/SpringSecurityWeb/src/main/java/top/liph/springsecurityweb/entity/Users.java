package top.liph.springsecurityweb.entity;

import lombok.Data;

/**
 * @author: lipenghui
 * @create: 2022-10-29 22
 **/
@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
}
