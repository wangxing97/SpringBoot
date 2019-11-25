package com.wx.springboot.config;

import com.wx.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration当前类是配置类，代替Spring以前的配置文件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；容器中默认的id名就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean生效");
        return new HelloService();
    }
}
