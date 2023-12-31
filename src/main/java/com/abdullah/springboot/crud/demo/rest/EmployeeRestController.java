package com.abdullah.springboot.crud.demo.rest;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.springboot.crud.demo.entity.Employee;
import com.abdullah.springboot.crud.demo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findEmployeeById(employeeId);
        if(theEmployee == null){
            throw new EmployeeNotFoundException("Employee Id Not Found - "+ employeeId);
        }
        return theEmployee;
    }
    @PutMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        if(theEmployee.getId() > employeeService.findAll().size() || theEmployee.getId()<=0){
            throw new EmployeeNotFoundException("Employee ID "+theEmployee.getId()+" Out Of Bounds");
        }
        Employee e = employeeService.save(theEmployee);
        if(e == null){
            throw new EmployeeNotFoundException("Employee" +theEmployee.getId()+"Not Found To Update");
        }
        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployeeById(@PathVariable int employeeId){

       Employee theEmployee =  employeeService.deleteEmployeeById(employeeId);
       if(theEmployee ==null){
        throw new EmployeeNotFoundException("Employee Id" + employeeId +" Not Found");
       }
       return theEmployee;
    }



}
