package com.wx.springboot.mapper;

import com.wx.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDeptById(Department dept);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department dept);

    @Select("select * from department")
    public List<Department> getDeptAll();
}
