package com.sxq.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: s x q
 * @Date: 2022/6/28 14:53
 * @Version: v1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentconsul()
    {
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
