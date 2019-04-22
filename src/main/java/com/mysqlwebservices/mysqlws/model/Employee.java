package com.mysqlwebservices.mysqlws.model;

import org.springframework.data.annotation.LastModifiedDate;
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
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}