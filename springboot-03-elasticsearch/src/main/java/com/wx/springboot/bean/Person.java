package com.wx.springboot.bean;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "es2",type = "person")
public class Person {

    private Integer id;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
