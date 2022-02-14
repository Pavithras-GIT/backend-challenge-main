package com.challenge.employee.domain;

import com.challenge.employee.EmployeeStates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    private Long id;
    private  String name;
    private String contractInformation;
    private int age;
    @Enumerated(EnumType.STRING)
    private EmployeeStates state;
}
