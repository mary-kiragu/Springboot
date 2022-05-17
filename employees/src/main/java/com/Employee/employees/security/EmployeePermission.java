package com.Employee.employees.security;

public enum EmployeePermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write");


    private String permissions;

    EmployeePermission(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
