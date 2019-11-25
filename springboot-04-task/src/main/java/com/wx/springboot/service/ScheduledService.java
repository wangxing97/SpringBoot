package com.wx.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ScheduledService {
    /**
     * 秒-分-时-几号-月-周几
     */
    //@Scheduled(cron = "0 * * * * MON-TUE")
    //@Scheduled(cron = "0,1,2,3,4,5 * * * * MON-TUE")每分钟的0-1-2-3-4-5秒都会运行
    //@Scheduled(cron = "0-5 * * * * MON-TUE")每分钟的0-1-2-3-4-5秒都会运行
    //@Scheduled(cron = "0/5 * * * * MON-TUE")每隔5秒启动一次
    public void hello(){
        System.out.println("hello...");
    }

}
