package com.ems.employee_management_system.controller;

import com.ems.employee_management_system.dto.EmployeeRequest;
import com.ems.employee_management_system.entity.Employee;
import com.ems.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeRequest request) {
        return service.addEmployee(
                request.getName(),
                request.getDeptId(),
                request.getSalary()
        );
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteEmployee(id);
    }
}
