package com.example.cache.dao;

import com.example.cache.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmployeeDao {

    @Select("select * from employee")
    public List<Employee> getEmployeesList();

    @Select("select * from employee where id = #{id}")
    public Employee getEmployee(Integer id);

    @Insert("insert into employee(employee_name,dept_id) values(#{employeeName},#{deptId})")
    public void insertEmployee(Employee employee);

    @Update("update employee set employee_name = #{employeeName},dept_id=#{deptId} where id = #{id}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void delete(Integer id);

}
