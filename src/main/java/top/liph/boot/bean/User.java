package top.liph.boot.bean;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:33
 **/
public class User {
    private String name;
    private Integer age;

    public User(){

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
