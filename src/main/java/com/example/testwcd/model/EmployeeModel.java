package com.example.testwcd.model;

import com.example.testwcd.entity.Employee;

import java.util.List;

public interface EmployeeModel {
    boolean save(Employee obj);
    List<Employee> findAll();
}
