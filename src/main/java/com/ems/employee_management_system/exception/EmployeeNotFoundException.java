package com.ems.employee_management_system.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(int id) {
        super("Employee not found with id: "+id);
    }
}
