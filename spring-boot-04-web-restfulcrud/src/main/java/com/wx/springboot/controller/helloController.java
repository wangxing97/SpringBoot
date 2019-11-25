package com.wx.springboot.controller;

import com.wx.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class helloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "user")String user){
        if(user.equals("wx")){
            throw new UserNotExistException();
        }
        return "hello";
    }

    @RequestMapping(value = "/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }

    @PostMapping( value = "/user/login")
    public String index(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/main";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
}
