package com.dispenser.service;

import com.dispenser.dao.EmployeeDao;
import com.dispenser.model.Employee;
import com.dispenser.util.DateSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public Employee getBest(List<Employee> employees) {
        Employee result = employees
                .stream()
                .reduce(employees.getFirst(), (a, e)
                        -> a = DateSupport.getDiff(a) > DateSupport.getDiff(e) ? a : e);
        return result;
    }
}
