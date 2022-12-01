package top.liph.springcloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.liph.springcloud.entity.Payment;

/**
* @author 86155
* @description 针对表【payment(支付表)】的数据库操作Mapper
* @createDate 2022-11-30 20:08:00
* @Entity top.liph.springcloud.entity.Payment
*/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}




