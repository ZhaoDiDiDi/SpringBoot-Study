package com.it.service;

import org.apache.dubbo.config.annotation.DubboService;

//zookeeper: 服务注册于发现

@DubboService   //可以被扫描到，在项目一启动就自动注册到注册中心
public class TicketServiceImp implements TicketService{
    @Override
    public String getTicket() {
        return "通向贵港车票";
    }
}
