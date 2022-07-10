package com.sxq.springcloud.dao;

import com.sxq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: s x q
 * @Date: 2022/6/23 10:45
 * @Version: v1.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
