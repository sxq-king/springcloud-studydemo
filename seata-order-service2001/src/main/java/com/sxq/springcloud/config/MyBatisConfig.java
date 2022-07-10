package com.sxq.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: s x q
 * @Date: 2022/7/7 10:19
 * @Version: v1.0
 */
@Configuration
@MapperScan({"com.sxq.springcloud.dao"})
public class MyBatisConfig {
}
