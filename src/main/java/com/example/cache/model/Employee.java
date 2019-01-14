package com.example.cache.model;

import java.io.Serializable;

public class Employee implements Serializable{

    private Integer id;
    private Integer deptId;
    private String employeeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
