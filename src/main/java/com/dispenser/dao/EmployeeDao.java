package com.dispenser.dao;

import com.dispenser.model.Employee;
import java.util.List;

public interface EmployeeDao {
   Employee getBest(List<Employee> employees);
}
