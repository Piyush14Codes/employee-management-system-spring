package com.ems.employee_management_system.service;

import com.ems.employee_management_system.entity.Department;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(String name , int deptId , double salary) {
        Department dept = Department.fromId(deptId);
        Employee emp = new Employee(name,dept,salary);
        return repository.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getEmployeeByName(String name) {
        return repository.findByNameContaining(name);
    }

    public long getTotalNoOfEmployees() {
        return repository.count();
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    public Employee updateEmployee(int id , String name , int deptId , double salary) {
        Employee emp = getEmployeeById(id);
        emp.setName(name);
        emp.setDept(Department.fromId(deptId));
        emp.setSalary(salary);
        repository.save(emp);
        return emp;
    }
}
