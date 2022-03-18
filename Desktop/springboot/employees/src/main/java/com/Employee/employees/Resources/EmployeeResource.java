package com.Employee.employees.Resources;

import com.Employee.employees.domain.*;
import com.Employee.employees.services.*;
import com.Employee.employees.services.vms.*;
import liquibase.pro.packaged.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.http.*;
import java.util.*;

@RestController
@RequestMapping(path="/api/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;
    private  final  Logger log= LoggerFactory.getLogger(EmployeeResource.class);
    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping
    ResponseEntity<List<Employee> >getAllEmployees(){
        log.info("Request to get a list of all employees");
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        log.info("Request to add an employee ");
      employeeService.addNewEmployee(employee);
        log.info("new Employee added");
    }
    @GetMapping(path = "{employeeId}")
    Optional<Employee> getOne(@PathVariable("employeeId") Long employeeId){
        return employeeService.getOne(employeeId);
    }
    @PutMapping(path="{employeeId}")
    public void updateEmployeeDetails(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody EmployeeVM employeeVM) {
        employeeService.updateEmployeeDetail(employeeId,employeeVM.getName(),employeeVM.getEmail(),employeeVM.getPhoneNumber(),employeeVM.getImageUrl(),employeeVM.getJobDescription());
    }

    @DeleteMapping(path="{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    @RequestMapping(path="/{name}")
    public List<Employee> findEmployeeByName(@PathVariable("name") String name){
        return employeeService.findEmployeeByName(name);
    }

    @GetMapping("/search")
    public List<Employee> findAll(@RequestParam (required = false) String text){
        log.debug("REST request to search all Employees  with text : {}", text);
        if (text == null){
            text = "";
        }

        return employeeService.search(text);
    }
}
