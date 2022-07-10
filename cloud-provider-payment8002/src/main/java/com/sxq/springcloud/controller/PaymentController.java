package com.sxq.springcloud.controller;

import com.sxq.springcloud.entities.CommonResult;
import com.sxq.springcloud.entities.Payment;
import com.sxq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: s x q
 * @Date: 2022/6/23 11:11
 * @Version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果:" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据库成功,服务端口:"+serverPort, result);
        }else {
            return new CommonResult(444, "插入数据库失败,服务端口:"+serverPort, null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果" + result);
        if(result != null){
            return new CommonResult(200, "查询成功,服务端口"+serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id+"\t服务端口:"+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
