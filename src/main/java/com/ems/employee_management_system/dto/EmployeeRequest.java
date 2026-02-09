package com.ems.employee_management_system.dto;

public class EmployeeRequest {

    private String name;
    private int deptId;
    private double salary;

    public String getName() {
        return name;
    }

    public int getDeptId() {
        return deptId;
    }

    public double getSalary() {
        return salary;
    }

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
