package com.wx.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class HelloController {

    @Autowired
    DataSource dataSource;

    @ResponseBody
    @GetMapping(value = "/test")
    public String contextLoads() throws SQLException {
       System.out.println("dataSource:"+dataSource.getClass());
        System.out.println("connection:"+dataSource.getConnection());
        return "success";
    }

}
