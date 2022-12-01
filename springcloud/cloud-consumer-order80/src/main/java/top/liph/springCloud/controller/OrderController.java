package top.liph.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.liph.springcloud.entity.Payment;
import top.liph.springcloud.vo.R;

import javax.annotation.Resource;

/**
 * @author: lipenghui
 * @create: 2022-11-30 22
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/addPayment")
    public R addPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/addPayment",payment,R.class);
    }

    @GetMapping("/getPayment/{id}")
    public R getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/"+id,R.class);
    }
}
