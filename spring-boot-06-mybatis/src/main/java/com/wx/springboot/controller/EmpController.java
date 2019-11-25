package com.wx.springboot.controller;

import com.wx.springboot.bean.Employee;
import com.wx.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee insertEmp(Employee emp){
        System.out.println("Emp:"+emp.toString());
        int i = employeeMapper.insertEmp(emp);
        System.out.println("Insert Result："+i);
        return emp;
    }

    @GetMapping("/empAll")
    public List<Employee> getEmpAll(){
        return employeeMapper.getEmpAll();
    }


}
