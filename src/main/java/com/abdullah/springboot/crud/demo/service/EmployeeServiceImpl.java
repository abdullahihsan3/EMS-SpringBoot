package com.abdullah.springboot.crud.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abdullah.springboot.crud.demo.dao.EmployeeDAO;
import com.abdullah.springboot.crud.demo.entity.Employee;
import com.abdullah.springboot.crud.demo.rest.EmployeeNotFoundException;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    private EmployeeDAO employeeDAO;
    @Override
    public List<Employee> findAll() {
      return employeeDAO.findAll();
    }
    @Override
    public Employee findEmployeeById(Integer id) {

        return employeeDAO.findEmployeeById(id);
    }
    @Transactional
    @Override
    public Employee deleteEmployeeById(Integer id) {
        List <Employee> employees = findAll();
        int length = employees.size();
        if(id<=0 || id>length){
            throw new EmployeeNotFoundException("Employee Id Out Of Bounds " + id+" Is Not A Valid Id");
        }
        Employee employeeDeleted = employeeDAO.deleteEmployeeById(id);
        return employeeDeleted;
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
    
}
