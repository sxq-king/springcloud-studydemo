package com.sxq.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: s x q
 * @Date: 2022/6/29 14:17
 * @Version: v1.0
 * 为了方便不写接口了
 */
@Service
public class PaymentService {

    /**
     * ----服务降级----
     * 正常访问，肯定ok的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "  线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id +"\t"+"ahhhhh";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "  线程池： " + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id:" + id +"\t"+"ahhhhh";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "  线程池： " + Thread.currentThread().getName() + "  8001系统繁忙请稍后再试,id:" + id +"\t"+"O(#_#)0";

    }

    /**
     * ----服务熔断----
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
