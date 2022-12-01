package top.liph.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lipenghui
 * @create: 2022-11-30 20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R <T>{
    private Integer code;
    private String message;
    private T data;

    public R(Integer code,String message){
        this(code,message,null);
    }

    public R(T data){
        this(200,"success",data);
    }
}
