package com.wx.springboot;

import com.wx.springboot.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    //创建交换器
    @Test
    public void createExchange(){
        //amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //System.out.println("创建完成");
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //System.out.println("创建完成");
        Binding binding = new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null);
        System.out.println("创建完成");
        amqpAdmin.declareBinding(binding);
    }

    /**
     * 1、单播 点对点
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造;定制消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);
        //object默认被当成消息体  只需要传入需要发送的对象，自动序列化发送给rabbitMq
        String exchange = "exchange.direct";
        String routeKey = "cslg.news";
        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象默认被序列化以后发出去
        rabbitTemplate.convertAndSend(exchange,routeKey,map);
    }

    @Test
    public void testObject() {
        String exchange = "exchange.direct";
        String routeKey = "cslg.news";
        rabbitTemplate.convertAndSend(exchange,routeKey,new Employee(1,"wx","wx@qq.com",1,0));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("cslg.emps");
        System.out.println(o.getClass());
        System.out.println(o.toString());
    }

    /**
     * 2、广播  1对多
     */
    @Test
    public void sendBroad(){
        rabbitTemplate.convertAndSend("exchange.fanout","nothing",new Employee(1,"wx","wx@qq.com",1,0));
    }

    @Test
    public void send(){
       rabbitTemplate.convertAndSend("amqpadmin.exchange","amqp.haha",new Employee(2,"测试","wx@qq.com",1,0));
    }

    @Test
    public void delete(){
        Binding binding = new Binding("cslg",Binding.DestinationType.QUEUE,"exchange.topic","cslg.#",null);
        amqpAdmin.removeBinding(binding);
        System.out.println("删除成功");
    }
}
