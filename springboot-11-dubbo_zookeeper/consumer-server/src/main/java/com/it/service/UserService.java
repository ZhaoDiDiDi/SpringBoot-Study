package com.it.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class UserService {
    //// 想拿到provider-server提供的票，要去注册中心拿到服务
    @DubboReference     //引用， ，可以定义路径相同的接口名
    TicketService ticketService;

    public void bugTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到 ==>" + ticket);
    }
}
