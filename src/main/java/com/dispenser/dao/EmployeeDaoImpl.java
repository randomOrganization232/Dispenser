package com.dispenser.dao;

import com.dispenser.model.Employee;
import com.dispenser.util.DateSupport;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private static final Logger employeeDaoImplLogger = Logger.getLogger(EmployeeDaoImpl.class.getSimpleName());

    @Override
    public Employee getBest(List<Employee> employees) {
        Employee result = employees
                .stream()
                .reduce(employees.getFirst(), (a, e)
                        -> a = DateSupport.getDiff(a) > DateSupport.getDiff(e) ? a : e);
        return result;
    }


}
