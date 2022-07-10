package com.sxq.springcloud.controller;

import com.sxq.springcloud.domain.CommonResult;
import com.sxq.springcloud.domain.Order;
import com.sxq.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: s x q
 * @Date: 2022/7/7 10:18
 * @Version: v1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }

}
