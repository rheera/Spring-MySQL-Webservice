package com.mysqlwebservices.mysqlws.dao;

import com.mysqlwebservices.mysqlws.model.Employee;
import com.mysqlwebservices.mysqlws.repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Spring expects DAOs to have service notation
@Service
//where we mess with data and stuff into repository using the model
public class employeeDAO {

    @Autowired
    employeeRepository employeeRepository;

    //save an employee
    public Employee newEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    //search employees
    public Employee employeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    //update an employee
    public Employee updateEmployee(Long id, String name){
        employeeRepository.getOne(id).setName(name);
        return employeeRepository.getOne(id);
    }

    //delete an employee by id
    public void deleteEmployeeById(Long id){
        employeeRepository.delete(employeeRepository.getOne(id));
    }

    //delete an employee
    public void deleteEmployee(Employee emp){
        employeeRepository.delete(emp);
    }

    //List of employees
    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }
}
