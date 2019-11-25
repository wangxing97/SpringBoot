package com.wx.springboot.controller;

import com.wx.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

   /* @ResponseBody
    @ExceptionHandler(value = {UserNotExistException.class})
    public Map handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(value = {UserNotExistException.class})
    public String handleException(Exception e, HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        req.setAttribute("javax.servlet.error.status_code",400);
        map.put("error","错误的请求");
        map.put("message",e.getMessage());
        req.setAttribute("ext",map);
        return "forward:/error";
    }
}
