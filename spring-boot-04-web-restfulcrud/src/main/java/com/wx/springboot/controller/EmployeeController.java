package com.wx.springboot.controller;

import com.wx.springboot.dao.DepartmentDao;
import com.wx.springboot.dao.EmployeeDao;
import com.wx.springboot.entities.Department;
import com.wx.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表界面
    @GetMapping(value = "/emps")
    public String lists(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
       /* return "redirect:/list";*/
    }

    //去员工添加页面
    @GetMapping(value = "/emp")
    public String goAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping(value = "/emp")
    public String addEmp(Employee emp){
//        System.out.println(emp);
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    //员工修改
    @GetMapping(value = "/emp/{id}")
    public String goEditPage(@PathVariable(value = "id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工修改
    @PutMapping(value = "/emp")
    public String editEmp(Employee emp){
        employeeDao.save(emp);
        return "redirect:/emps";
    }
    //员工删除
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable(value = "id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
