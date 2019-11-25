package com.wx.cache.controller;

import com.wx.cache.bean.Employee;
import com.wx.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/deleteemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "delete ok";
    }

    @GetMapping("/emp/name/{name}")
    public Employee getEmpByName(@PathVariable("name") String name){
        return employeeService.getEmpByName(name);
    }

    /*@GetMapping("/emp")
    public int insertEmp(Employee employee){
        int result = employeeService.insertEmp(employee);
        return result;
    }*/
}
