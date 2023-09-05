package com.abdullah.springboot.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abdullah.springboot.crud.demo.dao.EmployeeRepository;
import com.abdullah.springboot.crud.demo.entity.Employee;
import com.abdullah.springboot.crud.demo.rest.EmployeeNotFoundException;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
      return employeeRepository.findAll();
    }
    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
        List <Employee> employees = findAll();
        int length = employees.size();
        if(id<=0 || id>length){
            throw new EmployeeNotFoundException("Employee Id Out Of Bounds " + id+" Is Not A Valid Id");
        }
        employeeRepository.deleteById(id);
        return;
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    
}
