package com.sxq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sxq.springcloud.entities.CommonResult;
import com.sxq.springcloud.entities.Payment;
import com.sxq.springcloud.handle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: s x q
 * @Date: 2022/7/6 15:11
 * @Version: v1.0
 */
@RestController
public class RateLimitController {

    /**
     * 自定义通用的限流处理逻辑，
     blockHandlerClass = CustomerBlockHandler.class
     blockHandler = handleException2
     上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
     */
    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客户自定义限流处理逻辑",new Payment(2022L,"song"));
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }


    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException e){
        return new CommonResult(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }
}
