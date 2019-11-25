package com.wx.springboot.service;

import com.wx.springboot.bean.Employee;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @RabbitListener(queues = {"cslg.news","amqpadmin.queue"})
    public void receive(Employee emp){
        System.out.println("收到消息:"+emp);
    }

    @RabbitListener(queues = {"cslg"})
    public void receive02(Message msg){
        System.out.println("Body:"+msg.getBody());
        System.out.println("MessageProperties:"+msg.getMessageProperties());
    }
}
