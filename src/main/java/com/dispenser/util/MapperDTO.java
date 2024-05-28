package com.dispenser.util;

import com.dispenser.dto.EmployeeRequestDTO;
import com.dispenser.dto.EmployeeDTO;
import com.dispenser.model.Employee;
import com.dispenser.model.EmployeeRequest;
import lombok.*;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MapperDTO {
    private static final Logger mapperDTOLogger = Logger.getLogger(MapperDTO.class.getSimpleName());

    public static Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return Employee
                .builder()
                .id(employeeDTO.getId())
                .dateStart(DateSupport.getAsDate(employeeDTO.getDateStart()))
                .dateEnd(DateSupport.getAsDate(employeeDTO.getDateEnd()))
                .build();
    }

    public static EmployeeRequest convertToEmployeeResponse(EmployeeRequestDTO employeeRequestDTO) {

        EmployeeRequest employeeRequest = EmployeeRequest
                .builder()
                .employees(
                        employeeRequestDTO
                                .getEmployees()
                                .stream()
                                .map(MapperDTO::convertToEmployee)
                                .collect(Collectors.toList())
                )
                .build();
        mapperDTOLogger.info("\ndto ->>> " + employeeRequestDTO);
        mapperDTOLogger.info("\nnormal ->>> " + employeeRequest);

        return employeeRequest;
    }
}
