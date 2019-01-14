package com.example.cache.service;

import com.example.cache.model.Department;

import java.util.List;

public interface IDepartmentService {

    public List<Department> getAll() throws Exception;

    public Department insert (Department dept) throws Exception;

    public Department update (Department dept) throws Exception;

    public void delete (Integer id) throws Exception;

    public Department get (Integer id) throws Exception;
}
