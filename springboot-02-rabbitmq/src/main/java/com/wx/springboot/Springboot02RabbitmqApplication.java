package com.wx.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Springboot02RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02RabbitmqApplication.class, args);
    }

}
