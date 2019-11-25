package com.wx.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test01(){
        String[] str = new String[]{"1","2","3"};
        List<String> list = Arrays.asList(str);
        System.out.println(list);
    }



}
