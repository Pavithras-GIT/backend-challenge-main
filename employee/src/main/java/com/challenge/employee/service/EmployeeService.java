package com.challenge.employee.service;

import com.challenge.employee.EmployeeEvents;
import com.challenge.employee.EmployeeStates;
import com.challenge.employee.domain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;

public interface EmployeeService {

        Employee newEmployee(Employee employee);

        StateMachine<EmployeeStates, EmployeeEvents> addEmployee(Employee employee);

        StateMachine<EmployeeStates, EmployeeEvents> checkStatus(Long EmployeeId);

        StateMachine<EmployeeStates, EmployeeEvents> approve(Long EmployeeId);

        StateMachine<EmployeeStates, EmployeeEvents> unApprove(Long EmployeeId);

        StateMachine<EmployeeStates, EmployeeEvents> activate(Long EmployeeId);

        Employee getEmployee(int employeeId);
}

