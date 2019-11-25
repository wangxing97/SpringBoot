package com.wx.cache.service;

import com.wx.cache.bean.Department;
import com.wx.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptService {

    @Autowired
    @Resource
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = {"dept"},key = "#id")
    public Department getDeptById(Integer id){
        System.out.println("查询Dept:"+id);
        return departmentMapper.getDeptById(id);
    }
}
