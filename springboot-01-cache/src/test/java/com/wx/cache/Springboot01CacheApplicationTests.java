package com.wx.cache;

import com.wx.cache.bean.Employee;
import com.wx.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Resource
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * String、List、Set、Zset、Hash
     */
    @Test
    public void test01() {
        //操作String类型的
        /*ValueOperations<String, String> string = stringRedisTemplate.opsForValue();
        string.set("string1","spring boot string");
        String string1 = string.get("string1");
        System.out.println(string1);*/
        redisTemplate.opsForList().leftPushAll("list1","1","2","3");
        System.out.println(redisTemplate.opsForList().range("list1",0,-1));
    }

    @Test
    public void test02() {
        //测试保存对象
        Employee emp = employeeMapper.getEmpById(1);
        //redisTemplate.opsForValue().set("emp-01",emp);
        Object o = redisTemplate.opsForValue().get("emp-01");
        System.out.println(o);
    }

    @Test
    public void test10() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
