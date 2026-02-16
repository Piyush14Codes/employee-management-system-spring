package com.ems.employee_management_system.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Used for fetching request parameters
public class EmployeeRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    @Min(value = 1 , message = "Department Id must 1,2, or 3")
    @Max(value = 3 , message = "Department Id must 1,2, or 3")
    private int deptId;

    @Min(value = 0 , message = "Salary must be non-negative")
    private double salary;

    //getters
    public String getName() {
        return name;
    }

    public int getDeptId() {
        return deptId;
    }

    public double getSalary() {
        return salary;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
