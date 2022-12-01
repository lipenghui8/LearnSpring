package top.liph.springcloud.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liph.springcloud.entity.Payment;
import top.liph.springcloud.mapper.PaymentMapper;
import top.liph.springcloud.service.PaymentService;

/**
* @author 86155
* @description 针对表【payment(支付表)】的数据库操作Service实现
* @createDate 2022-11-30 20:08:00
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService {

}




