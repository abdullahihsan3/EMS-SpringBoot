package com.abdullah.springboot.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdullah.springboot.crud.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // There is no need to write code
}
