package com.wx.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wx.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void buyTicket(){
        System.out.println("买到票了："+ticketService.getTic());
    }
}
