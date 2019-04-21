package com.mysqlwebservices.mysqlws;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

//this is a model class, so you want to add entity
@Entity
//Adds table with the name to SQL
@Table(name = "Employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    //column names
    //make id primary key
    @Id
    //make id auto increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //don't want these columns to be blank
    @NotBlank
    private String name;

    @NotBlank
    private String designation;

    @NotBlank
    private String expertise;

    @NotBlank
    private Date createdAt;
}