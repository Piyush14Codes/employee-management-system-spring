package com.ems.employee_management_system.exception;

public class InvalidDepartmentException extends RuntimeException {
    public InvalidDepartmentException(String message) {
        super(message);
    }

    public InvalidDepartmentException(int deptId) {
        super("Invalid department id: " + deptId);
    }
}
