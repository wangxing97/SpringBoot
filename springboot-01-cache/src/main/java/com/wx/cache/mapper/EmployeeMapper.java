package com.wx.cache.mapper;

import com.wx.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

import javax.annotation.Generated;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee emp);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmp(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(lastName,email,gender,d_id) values (#{lastName},#{email},#{gender},#{dId})")
    public int insertEmp(Employee emp);

    @Select("select * from employee where lastName=#{name}")
    public Employee getEmpByName(String name);
}
