package com.sxq.springcloud.service;

import com.sxq.springcloud.domain.Order;

public interface OrderService {


    /**
     * 创建订单
     */
    void create(Order order);

}
