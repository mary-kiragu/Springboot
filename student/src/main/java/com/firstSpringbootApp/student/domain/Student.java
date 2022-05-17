package com.firstSpringbootApp.student.domain;

import lombok.*;

import javax.persistence.*;
import java.time.*;
@Data
@Entity
@Table(name="tbl_student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student() {
        // for persistence
    }

    public Student(String name, String email, Integer age, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Student(String name, String email, Integer age, LocalDate dob, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.address = address;
    }

    @Column(name="name", nullable=false,length = 50)
    private String name;
    @Column(name="email",length = 50)
    private  String  email;
    @Column(name="age")
    private Integer age;
    @Column(name="dob")
    private LocalDate dob;
    @Column(name = "address")
    private String address;

}


