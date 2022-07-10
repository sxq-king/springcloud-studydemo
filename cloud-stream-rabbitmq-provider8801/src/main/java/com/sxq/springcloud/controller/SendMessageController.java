package com.sxq.springcloud.controller;

import com.sxq.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: s x q
 * @Date: 2022/7/5 09:04
 * @Version: v1.0
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider MessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return MessageProvider.send();

    }
}
