package com.dispenser.util;

import com.dispenser.dto.EmployeeRequestDTO;
import com.dispenser.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.List;


@Component("dtoValidator")
public class EmployeeRequestDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
         EmployeeRequestDTO employee = (EmployeeRequestDTO) target;
         List<Employee> employeeList = MapperDTO.convertToEmployeeRequest(employee)
                 .getEmployees()
                 .stream()
                 .filter(x -> x.getDateStart().getTime() > x.getDateEnd().getTime())
                 .toList();
         if (!employeeList.isEmpty())
             errors.rejectValue("employees", "400", "dateStart should be < than dateEnd!");
    }
}
