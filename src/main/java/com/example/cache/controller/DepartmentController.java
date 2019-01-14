package com.example.cache.controller;


import com.example.cache.model.Department;
import com.example.cache.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/list")
    public List<Department> queryDepartment(){
        List<Department> departments = new ArrayList<>();
        try{
            departments = departmentService.getAll();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DepartmentController-queryDepartment"+e);
        }
        return departments;
    }

    @GetMapping("/add")
    public void queryDepartment(Department dept){
        try{
            departmentService.insert(dept);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DepartmentController-queryDepartment"+e);
        }
    }

    @GetMapping("/get/{id}")
    public Department get(@PathVariable("id") Integer id){
        try{
            return departmentService.get(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DepartmentController-queryDepartment"+e);
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        try{
            departmentService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DepartmentController-queryDepartment"+e);
        }
    }

    @RequestMapping("/update")
    public void update(Department dept){
        try{
            departmentService.update(dept);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DepartmentController-queryDepartment"+e);
        }
    }
}
