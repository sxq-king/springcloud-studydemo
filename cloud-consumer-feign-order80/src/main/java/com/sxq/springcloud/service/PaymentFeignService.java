package com.sxq.springcloud.service;

import com.sxq.springcloud.entities.CommonResult;
import com.sxq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: s x q
 * @Date: 2022/6/28 18:49
 * @Version: v1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) ;

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

}
