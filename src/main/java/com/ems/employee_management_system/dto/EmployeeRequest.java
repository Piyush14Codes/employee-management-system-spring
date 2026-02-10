package com.ems.employee_management_system.dto;

//Used for fetching request parameters
public class EmployeeRequest {

    private String name;
    private int deptId;
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
