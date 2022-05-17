package com.Employee.employees.services;

import com.Employee.employees.domain.*;
import com.Employee.employees.repositories.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Logger log=LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public Employee addNewEmployee(Employee employee) {
        //user doesn't input userId it is randomly generated everytime an employee is added
        employee.setJobCode(UUID.randomUUID().toString());
        Optional<Employee> employeeOptional=employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            log.info("Employee already exists");
        }
        employeeRepository.save(employee);
        log.info("Student Saved");

        return employee;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees=employeeRepository.findAll();
        return allEmployees;
    }
    public Optional<Employee> getOne(Long employeeId){
        Optional<Employee> employeeOptional=employeeRepository.findById(employeeId);
        log.info("Found employee: {}",employeeOptional);
        return employeeOptional;
    }

    //method to update employee details
    public Optional<Employee> updateEmployeeDetail(Long employeeId,String name,String email,String phoneNumber,String imageUrl,String jobDescription){
        Optional<Employee> employeeOptional=employeeRepository.findById(employeeId);
        log.info("Found the student",employeeOptional);

        if(employeeOptional.isPresent()){
            Employee employee=employeeOptional.get();
            if(name!=null && name.length()>0 && !Objects.equals(employeeOptional.get(),name)){
                employee.setName(name);

            }
            if(email!=null && email.length()>0 && !Objects.equals(employeeOptional.get(),email)){
                employee.setEmail(email);

            }
            if(phoneNumber!=null && phoneNumber.length()>0 && !Objects.equals(employeeOptional.get(),phoneNumber)){
                employee.setPhoneNumber(phoneNumber);

            }
            if(imageUrl!=null && imageUrl.length()>0 && !Objects.equals(employeeOptional.get(),imageUrl)){
                employee.setImageURL(imageUrl);
            }
            if(jobDescription!=null && jobDescription.length()>0 && !Objects.equals(employeeOptional.get(),jobDescription)){
                employee.setJobDescription(jobDescription);
            }

            //save updates
            return Optional.of(employeeRepository.save(employee));
        }

        return employeeOptional;

    }

    public List<Employee> findEmployeeByName(String name) {
        List<Employee> filteredEmployees=employeeRepository.findEmployeeByName(name);
        log.info("Found the names below",filteredEmployees);
        return filteredEmployees;
    }

    public void deleteEmployee(Long employeeId) {
        boolean exist=employeeRepository.existsById(employeeId);
        if (!exist){
            throw new IllegalStateException("student doesn't exist");

        }
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> search(String text) {
        List<Employee> filtered=employeeRepository.findByNameContainingOrEmailContaining(text,text);
        return filtered;
    }
}
