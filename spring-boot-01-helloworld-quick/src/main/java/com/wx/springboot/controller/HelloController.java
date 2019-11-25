package com.wx.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String handle() {
        return "hello spring-boot";
    }
}
