package com.wx.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        //日志级别（低->高） trace->debug->info->warn->error
        //可以调整输出的日志级别；日志就只会在这个级别以后的高级别生效
        logger.trace("logger trace");
        logger.debug("logger debug");
        //SpringBoot默认是info级别
        //在properties里调整级别logging.level.com.wx = trace
        logger.info("logger info");
        logger.warn("logger warn");
        logger.error("logger error");
    }

}
