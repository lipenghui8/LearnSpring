package top.liph.boot.bean;

/**
 * @author: Mr.Li
 * @create: 2022-02-08 18:39
 **/
public class Pet {
    private String name;

    public Pet(){
    }

    public Pet(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
