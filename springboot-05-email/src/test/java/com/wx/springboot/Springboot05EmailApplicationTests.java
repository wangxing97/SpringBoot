package com.wx.springboot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05EmailApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    public void contextLoads() {
        //long a1 = System.currentTimeMillis();
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject("SpringBoot-Email");
        msg.setText("哈哈哈哈哈哈哈哈阿斯达所大所大所多阿萨斯多啊实打实大师");
        msg.setTo("1027923428@qq.com");
        msg.setFrom("superstarwx@163.com");//必须是设置，否则报错...
        mailSender.send(msg);
        //long a2 = System.currentTimeMillis();
        //System.out.println((a2-a1));
    }

    /**
     * 测试复杂的邮件发送
     */
    @Test
    public void test02() throws Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg,true);
        helper.setFrom("superstarwx@163.com");
        helper.setTo("1027923428@qq.com");
        helper.setSubject("SpringBoot-Html");
        helper.setText("<a href='www.baidu.com'>点击这里进行认证...</a>",true);
        File file1 = ResourceUtils.getFile("classpath:images/1.jpg");
        File file2 = ResourceUtils.getFile("classpath:images/2.jpg");
        helper.addAttachment("1.jpg",file1);
        helper.addAttachment("2.jpg",file2);
        mailSender.send(msg);
    }

}
