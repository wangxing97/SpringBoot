package com.wx.cache.controller;

import com.wx.cache.bean.Department;
import com.wx.cache.mapper.DepartmentMapper;
import com.wx.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }
}
