package com.mysqlwebservices.mysqlws.controllers;

import com.mysqlwebservices.mysqlws.dao.employeeDAO;
import com.mysqlwebservices.mysqlws.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeDAO.allEmployees();
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid){
        Employee emp = employeeDAO.employeeById(empid);
        if (emp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);
    }

    //update an employee by id
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid, @Valid @RequestBody Employee empDetails){
        Employee emp = employeeDAO.employeeById(empid);
        if (emp == null){
            return ResponseEntity.notFound().build();
        }
        emp.setName(empDetails.getName());
        emp.setDesignation(empDetails.getDesignation());
        emp.setExpertise(empDetails.getExpertise());
        //check to see if we don't have to do a save after updating this and
        //Employee updatedEmployee = employeeDAO.newEmployee(emp);
        //return ResponseEntity.ok().body(updatedEmployee);
        return ResponseEntity.ok().body(emp);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid){
        Employee emp = employeeDAO.employeeById(empid);
        if (emp == null){
            return ResponseEntity.notFound().build();
        }
        employeeDAO.deleteEmployee(emp);
        return ResponseEntity.ok().build();
    }

}
