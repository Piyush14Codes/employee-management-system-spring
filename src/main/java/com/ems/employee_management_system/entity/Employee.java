package com.ems.employee_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id")
    private int employeeId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Department department;

    private double salary;

    public Employee(String name , Department department , double salary){
        setName(name);
        setDept(department);
        setSalary(salary);
    }
    public Employee(){}

    //getter
    public int getEmployeeId(){
        return employeeId;
    }

    public String getName(){
        return name;
    }

    public Department getDepartment(){
        return department;
    }

    public double getSalary(){
        return salary;
    }

    //setter
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDept(Department department) {
        this.department = department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}

