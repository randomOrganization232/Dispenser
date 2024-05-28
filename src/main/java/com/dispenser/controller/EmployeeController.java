package com.dispenser.controller;

import com.dispenser.dto.EmployeeRequestDTO;
import com.dispenser.model.EfficiencyResponse;
import com.dispenser.service.EmployeeService;
import com.dispenser.util.MapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger employeeControllerLogger = Logger.getLogger(EmployeeController.class.getSimpleName());
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/best")
    public ResponseEntity<EfficiencyResponse> getEfficiencyEmployee(@RequestBody EmployeeRequestDTO employees){
        employeeControllerLogger.info("Пришло: " + employees);
        EfficiencyResponse efficiencyResponse = new EfficiencyResponse(
                employeeService.getBest(MapperDTO.convertToEmployeeResponse(employees).getEmployees())
        );
        employeeControllerLogger.info("Отдам: " + efficiencyResponse);
        return new ResponseEntity<>(efficiencyResponse, HttpStatus.OK);
    }
}
