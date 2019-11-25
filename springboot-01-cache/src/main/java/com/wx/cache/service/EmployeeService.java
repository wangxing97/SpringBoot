package com.wx.cache.service;

import com.wx.cache.bean.Employee;
import com.wx.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeService {

    @Autowired
    @Resource
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"}/*,keyGenerator = "myKeyGenerator"*/,key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询：" + id + "员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(cacheNames = {"emp"},key = "#emp.id")
    public Employee updateEmp(Employee emp){
        employeeMapper.updateEmp(emp);
        return emp;
    }
    //org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
    public int insertEmp(Employee emp) {
        int result = employeeMapper.insertEmp(emp);
        return result;
    }

    @CacheEvict(cacheNames = {"emp"},key = "#id")
    public void deleteEmp(Integer id){
        //employeeMapper.deleteEmp(id);
        System.out.println("删除员工:"+id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "emp",key = "#name")
            },
            put = {
                    @CachePut(cacheNames = "emp",key = "#result.id")
            }
    )
    public Employee getEmpByName(String name){
        return employeeMapper.getEmpByName(name);
    }
}
