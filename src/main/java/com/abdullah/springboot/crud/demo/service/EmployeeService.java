package com.abdullah.springboot.crud.demo.service;

import java.util.List;
import java.util.Optional;

import com.abdullah.springboot.crud.demo.entity.Employee;

public interface EmployeeService{
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    void deleteById(Integer id);
    Employee save(Employee employee);
}