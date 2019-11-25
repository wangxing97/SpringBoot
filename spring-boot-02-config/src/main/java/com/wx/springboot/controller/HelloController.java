package com.wx.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value(value = "${person.last-name}")
    private String name;

    @RequestMapping(value = "/sayhello")
    public String sayHello() {
        return "hello," + name;
    }
}
