package com.ems.employee_management_system.controller;

import com.ems.employee_management_system.dto.EmployeeRequest;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest request) {
        log.info("Adding employee: name={}, deptId={}, salary={}", request.getName(), request.getDeptId(), request.getSalary());

        Employee employee = service.addEmployee(
                request.getName(),
                request.getDeptId(),
                request.getSalary()
        );
        log.info("Employee added successfully: id={}, name={}", employee.getEmployeeId(), employee.getName());
        return employee;

    }

    @GetMapping
    public List<Employee> getAll() {
        log.info("Fetching all employees");
        List<Employee> employees = service.getAllEmployees();
        log.info("Retrieved {} employees",employees.size());
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        log.info("Fetching employee by id={}",id);
        Employee employee = service.getEmployeeById(id);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id ,@Valid @RequestBody EmployeeRequest updateEmployee) {
        log.info("Updating employee id={} , name={} , salary={}",id,updateEmployee.getName(),updateEmployee.getSalary());
        Employee employee = service.updateEmployee(id,updateEmployee.getName(),updateEmployee.getDeptId(),updateEmployee.getSalary());
        log.info("Employee id={} updated successfully",id);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        log.info("Deleting employee id={}", id);
        service.deleteEmployee(id);
        log.info("Employee id={} deleted successfully", id);
    }

    @GetMapping("/count")
    public long getTotalEmployees() {
        log.info("Fetching total employee count");
        long count = service.getTotalNoOfEmployees();
        log.info("Total employees: {}", count);
        return count;
    }

    @GetMapping("?name=...")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        log.info("Fetching employees by name={}",name);
        List<Employee> employeeList = service.getEmployeeByName(name);
        log.info("Found {} employee(s) for name={}", employeeList.size() , name);
        return employeeList;
    }


}
