package com.challenge.employee.service;

import com.challenge.employee.EmployeeEvents;
import com.challenge.employee.EmployeeStates;
import com.challenge.employee.domain.Employee;
import org.springframework.statemachine.StateMachine;

public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public Employee newEmployee(Employee employee) {
        return null;
    }

    @Override
    public StateMachine<EmployeeStates, EmployeeEvents> addEmployee(Employee employee) {
        return null;
    }

    @Override
    public StateMachine<EmployeeStates, EmployeeEvents> checkStatus(Long EmployeeId) {
        return null;
    }

    @Override
    public StateMachine<EmployeeStates, EmployeeEvents> approve(Long EmployeeId) {
        return null;
    }

    @Override
    public StateMachine<EmployeeStates, EmployeeEvents> unApprove(Long EmployeeId) {
        return null;
    }

    @Override
    public StateMachine<EmployeeStates, EmployeeEvents> activate(Long EmployeeId) {
        return null;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return null;
    }
}
