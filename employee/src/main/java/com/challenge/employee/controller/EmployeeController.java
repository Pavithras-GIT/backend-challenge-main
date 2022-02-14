package com.challenge.employee.controller;

import com.challenge.employee.domain.Employee;
import com.challenge.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employee = (Employee) service.addEmployee(employee);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/employeeDetails/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) throws Exception {
        Employee employee = service.getEmployee(employeeId);
        return  ResponseEntity.ok(employee);
    }
}
