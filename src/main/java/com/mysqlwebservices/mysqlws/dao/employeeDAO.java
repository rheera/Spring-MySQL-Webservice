package com.mysqlwebservices.mysqlws.dao;

import com.mysqlwebservices.mysqlws.model.Employee;
import com.mysqlwebservices.mysqlws.repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

//where we mess with data and stuff into repository using the model
public class employeeDAO {

    @Autowired
    employeeRepository employeeRepository;

    //save an employee
    public void newEmployee(Employee emp){
        employeeRepository.save(emp);
    }

    //search employees
    public Employee employeeById(Long id){
        return employeeRepository.getOne(id);
    }

    //update an employee
    public void updateEmployee(Long id, String name){
        employeeRepository.getOne(id).setName(name);
    }

    //delete an employee
    public void deleteEmployeeById(Long id){
        employeeRepository.delete(employeeRepository.getOne(id));
    }
}
