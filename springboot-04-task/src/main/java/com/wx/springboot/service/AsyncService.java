package com.wx.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
            System.out.println("3秒已过...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
