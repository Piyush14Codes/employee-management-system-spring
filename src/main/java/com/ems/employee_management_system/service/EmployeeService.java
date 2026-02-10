package com.ems.employee_management_system.service;

import com.ems.employee_management_system.entity.Department;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.repository.EmployeeRepository;
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
    public Employee addEmployee(String name , int deptId , double salary) {
        Department dept = Department.fromId(deptId);
        Employee emp = new Employee(name,dept,salary);
        return repository.save(emp);
    }

    //Retrieving all the employees from the DB
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    //Retrieving employee by ID
    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
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
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    //Updating employee details
    public Employee updateEmployee(int id , String name , int deptId , double salary) {
        Employee emp = getEmployeeById(id);
        emp.setName(name);
        emp.setDept(Department.fromId(deptId));
        emp.setSalary(salary);
        repository.save(emp);
        return emp;
    }
}
