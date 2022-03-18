package com.Employee.employees.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {
    public Employee() {
        //for persistence
    }

    public Employee(String name, String email, String phoneNumber, String imageURL) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageURL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name="jobDescription")
    private  String jobDescription;
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "jobCode", nullable=false, updatable = false)
    private String jobCode;

}
