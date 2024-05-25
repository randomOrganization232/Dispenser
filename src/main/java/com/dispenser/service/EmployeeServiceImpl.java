package com.dispenser.service;

import com.dispenser.dao.EmployeeDao;
import com.dispenser.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee getBest(List<Employee> employees) {
        return employeeDao.getBest(employees);
    }
}
