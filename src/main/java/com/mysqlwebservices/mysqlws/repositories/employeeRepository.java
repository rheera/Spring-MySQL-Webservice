package com.mysqlwebservices.mysqlws.repositories;

import com.mysqlwebservices.mysqlws.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee, Long> {


}
