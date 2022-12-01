package top.liph.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getPayment/{id}")
    public R getPayment(@PathVariable("id") Integer id){
        return new R(paymentService.getById(id)+serverPort);
    }

    @PostMapping("/addPayment")
    public R addPayment(@RequestBody Payment payment){
        return new R(paymentService.save(payment)+serverPort);
    }

    @GetMapping("/discovery")
    public R discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****service",service);
        }

        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return new R(discoveryClient);
    }
}
