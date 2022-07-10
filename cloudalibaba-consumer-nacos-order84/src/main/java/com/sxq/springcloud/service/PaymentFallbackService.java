package com.sxq.springcloud.service;

import com.sxq.springcloud.entities.CommonResult;
import com.sxq.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Auther: s x q
 * @Date: 2022/7/7 08:22
 * @Version: v1.0
 */

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {

        return new CommonResult<>(44444,"服务降级返回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
