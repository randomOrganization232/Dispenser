package com.dispenser.service;

import com.dispenser.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getBest(List<Employee> employees);
}
