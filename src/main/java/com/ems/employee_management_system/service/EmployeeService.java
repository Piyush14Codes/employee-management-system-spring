package com.ems.employee_management_system.service;

import com.ems.employee_management_system.entity.Department;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.exception.EmployeeNotFoundException;
import com.ems.employee_management_system.exception.InvalidDepartmentException;
import com.ems.employee_management_system.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    //Adding a single employee to DB
    @Transactional
    public Employee addEmployee(String name , int deptId , double salary) {
        Department dept;
        try {
            dept = Department.fromId(deptId);
        } catch(IllegalArgumentException e) {
            throw new InvalidDepartmentException(deptId);
        }
        Employee emp = new Employee(name,dept,salary);
        return repository.save(emp);
    }

    //Retrieving all the employees from the DB
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    //Retrieving employee by ID
    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //Retrieving employee by name
    public List<Employee> getEmployeeByName(String name) {
        return repository.findByNameContaining(name);
    }

    //Getting total no of employees
    public long getTotalNoOfEmployees() {
        return repository.count();
    }

    //Deleting employee records by ID
    @Transactional
    public void deleteEmployee(int id) {
        if(!repository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        repository.deleteById(id);
    }

    //Updating employee details
    @Transactional
    public Employee updateEmployee(int id , String name , int deptId , double salary) {
        Department dept;
        try {
            dept = Department.fromId(deptId);
        } catch(IllegalArgumentException e) {
            throw new InvalidDepartmentException(deptId);
        }
        Employee emp = getEmployeeById(id);
        emp.setName(name);
        emp.setDept(dept);
        emp.setSalary(salary);
        repository.save(emp);
        return emp;
    }
}
