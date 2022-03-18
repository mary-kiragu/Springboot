package com.Employee.employees.repositories;

import com.Employee.employees.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        List<Employee> findEmployeeByName(String name);

        Optional<Employee> findEmployeeByEmail(String email);
        List<Employee> findByNameContainingOrEmailContaining(String text, String text2);
}
