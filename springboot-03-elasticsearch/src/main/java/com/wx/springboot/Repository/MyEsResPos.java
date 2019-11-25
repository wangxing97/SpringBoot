package com.wx.springboot.Repository;

import com.wx.springboot.bean.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

public interface MyEsResPos extends CrudRepository<Person,Integer> {
}
