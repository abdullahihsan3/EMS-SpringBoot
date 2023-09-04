package com.abdullah.springboot.crud.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abdullah.springboot.crud.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }
    @Override
    public Employee findEmployeeById(Integer id) {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee where id=:theId", Employee.class);
        theQuery.setParameter("theId", id.toString());
        return theQuery.getSingleResult();

    }   
    @Override
    public Employee deleteEmployeeById(Integer id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
        return employee;
    }
    @Override
    public Employee save(Employee employee) {
       Employee dbEmployee = entityManager.merge(employee);
       return dbEmployee;
    }
    
}
