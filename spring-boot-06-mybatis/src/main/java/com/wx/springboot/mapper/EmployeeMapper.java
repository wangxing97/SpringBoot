package com.wx.springboot.mapper;

import com.wx.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee emp);

    public List<Employee> getEmpAll();
}
