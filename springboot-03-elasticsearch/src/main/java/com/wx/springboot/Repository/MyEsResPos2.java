package com.wx.springboot.Repository;

import com.wx.springboot.bean.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MyEsResPos2 extends ElasticsearchRepository<Person,Integer> {
}
