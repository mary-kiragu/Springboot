package com.Employee.employees.services.vms;

import lombok.*;

import java.io.*;
@Data
public class EmployeeVM implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;
    private String imageUrl;
    private String jobDescription;
    private String jobCode;


}
