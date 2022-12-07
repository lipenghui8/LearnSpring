package top.liph.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.liph.springcloud.entity.Payment;
import top.liph.springcloud.service.PaymentService;
import top.liph.springcloud.vo.R;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lipenghui
 * @create: 2022-11-30 20
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPayment/{id}")
    public R getPayment(@PathVariable("id") Integer id){
        return new R(paymentService.getById(id)+serverPort);
    }

    @PostMapping("/addPayment")
    public R addPayment(@RequestBody Payment payment){
        return new R(paymentService.save(payment)+serverPort);
    }

}
