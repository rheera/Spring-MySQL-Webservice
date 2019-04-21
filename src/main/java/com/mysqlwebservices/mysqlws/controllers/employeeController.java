package com.mysqlwebservices.mysqlws.controllers;

import com.mysqlwebservices.mysqlws.dao.employeeDAO;
import com.mysqlwebservices.mysqlws.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(employeeController.BASE_URL)
//All URLs will be controlled form here
public class employeeController {
    //base url, don't repeat yourself, you can put it in a property file externalize it to easily change it
    public static final String BASE_URL = "/company";

    @Autowired
    employeeDAO employeeDAO;

    //Save an employee
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee emp){
        return employeeDAO.newEmployee(emp);
    }

    //get all employees
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeDAO.allEmployees();
    }

    @DeleteMapping
    public void deleteEmployee(Employee emp){
        employeeDAO.deleteEmployee(emp);
    }

}
