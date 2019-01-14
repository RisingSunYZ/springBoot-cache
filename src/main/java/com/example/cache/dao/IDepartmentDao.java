package com.example.cache.dao;

import com.example.cache.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDepartmentDao {

    @Select("select * from department")
    public List<Department> getAll() throws Exception;

    @Select("select * from department where id = #{id}")
    public Department getOne(Integer id) throws Exception;

    @Insert({"insert into department (dept_name) values(#{deptName})"})
    @SelectKey(keyProperty="id",before=false,statement="SELECT LAST_INSERT_ID()",resultType=int.class,keyColumn="id")
    public int insert(Department department) throws Exception;

    @Update("update department set dept_name = #{deptName} where id= #{id}")
    public void update(Department department) throws Exception;

    @Delete("delete from department where id = #{id}")
    public void delete(Integer id) throws Exception;
}
