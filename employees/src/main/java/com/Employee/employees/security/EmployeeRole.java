package com.Employee.employees.security;

import com.google.common.collect.*;

import java.util.*;

public enum EmployeeRole {
    EMPLOYEE(Sets.newHashSet(EmployeePermission.EMPLOYEE_READ)),
    ADMIN(Sets.newHashSet(EmployeePermission.EMPLOYEE_READ,EmployeePermission.EMPLOYEE_WRITE));
    private final Set<EmployeePermission> permissions;
    EmployeeRole(Set<EmployeePermission> permissions) {
        this.permissions = permissions;
    }


}
