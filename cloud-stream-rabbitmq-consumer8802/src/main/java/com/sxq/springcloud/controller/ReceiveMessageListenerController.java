package com.sxq.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Auther: s x q
 * @Date: 2022/7/5 09:21
 * @Version: v1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 消息消费者
     * @param message 消息内容
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号---->接收到的消息:"+message.getPayload() + "\t Port:" + serverPort);
    }
}
