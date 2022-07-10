package com.sxq.springcloud.service.impl;

import com.sxq.springcloud.service.IMessageProvider;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


import javax.annotation.Resource;
import java.util.UUID;


/**
 * @Auther: s x q
 * @Date: 2022/7/5 08:53
 * @Version: v1.0
 */
@EnableBinding(Source.class)    //定于消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***serial: "+serial);
        return serial;
    }
}
