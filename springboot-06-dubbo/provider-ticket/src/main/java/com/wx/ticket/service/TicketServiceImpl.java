package com.wx.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;

@EnableDubbo
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTic() {
        return "《新三国》";
    }
}
