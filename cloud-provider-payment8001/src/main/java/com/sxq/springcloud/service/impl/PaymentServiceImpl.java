package com.sxq.springcloud.service.impl;

import com.sxq.springcloud.dao.PaymentDao;
import com.sxq.springcloud.entities.Payment;
import com.sxq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: s x q
 * @Date: 2022/6/23 11:04
 * @Version: v1.0
 * @Autowired 来自spring
 * @Resource  java自带
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
