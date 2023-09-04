package com.abdullah.springboot.crud.demo.dao;

import java.util.List;

import com.abdullah.springboot.crud.demo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findEmployeeById(Integer id);
    Employee deleteEmployeeById(Integer id);
    Employee save(Employee employee);
    
}
