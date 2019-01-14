package com.example.cache.service.impl;

import com.example.cache.dao.IDepartmentDao;
import com.example.cache.model.Department;
import com.example.cache.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames="department",cacheManager = "deptRedisCacheManager")
@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private IDepartmentDao departmentDao;

    @Cacheable(key="'depts'+#root.methodName") //cacheable的key是不能使用result的参数的
    @Override
    public List<Department> getAll() throws Exception{
        System.out.println("进来了.............");
        return departmentDao.getAll();
    }


    @Caching(put={
            @CachePut(key = "'yangzhao-'+#dept.id")
    },evict = {
            @CacheEvict(key="'deptsgetAll'")
    })
    @Override
    public Department insert(Department dept) throws Exception {
        return 1 == departmentDao.insert(dept)?dept:null;
    }

    @Caching(put={
            @CachePut(key = "'yangzhao-'+#dept.id")
    },evict = {
            @CacheEvict(key="'deptsgetAll'")
    })
    @Override
    public Department update(Department dept) throws Exception {
        departmentDao.update(dept);
        return dept;
    }

    @Caching(evict={
            @CacheEvict(keyGenerator = "myKeyGenerator",beforeInvocation = true),//方法执行前清空缓存 allEntries = true清空所有
            @CacheEvict(key="'depts'+'getAll'")
    })
//    @CacheEvict(allEntries = true)
    @Override
    public void delete(Integer id) throws Exception {
        departmentDao.delete(id);
    }

    @Cacheable(keyGenerator = "myKeyGenerator",condition = "#id > 16") //满足条件才缓存 与 unless 相反
    @Override
    public Department get(Integer id) throws Exception {
        System.out.println("get............");
        return departmentDao.getOne(id);
    }

}
