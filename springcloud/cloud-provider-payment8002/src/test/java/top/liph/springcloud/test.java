package top.liph.springcloud;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.liph.springcloud.entity.Payment;
import top.liph.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author: lipenghui
 * @create: 2022-12-06 23
 **/
@SpringBootTest
public class test {

    @Resource
    PaymentService paymentService;

    @Test
    public void insert(){
        for(int i=0;i<100;i++){
            Payment payment=new Payment(getRandomString());
            paymentService.save(payment);
        }
    }

    public static String getRandomString(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<5;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
