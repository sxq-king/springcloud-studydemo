package com.sxq.springcloud;

import com.sxq.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @Auther: s x q
 * @Date: 2022/6/23 15:56
 * @Version: v1.0
 *
 *
 * @RibbonClient ： 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效，形如：
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
