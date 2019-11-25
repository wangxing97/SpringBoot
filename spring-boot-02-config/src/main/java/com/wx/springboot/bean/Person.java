package com.wx.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件相关的配置进行绑定
 * @ConfigurationProperties @Value
 * 批量注入                  单个注入
 * 支持松散绑定               不支持
 * 不支持SpEL(#{3*5})        支持
 * 支持JSR303数据校验         不支持
 * 支持复杂类型封装           不支持
 * 默认去全局配置文件中找
 * @PropertySource导入propetis文件
 *
 */
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:person.properties",ignoreResourceNotFound = true)
public class Person {

    @Value(value = "${person.last-name}")
    private String lastName;
    @Value(value = "#{9*2}")
    private Integer age;
    @Value(value = "true")
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
