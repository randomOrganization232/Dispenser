package com.dispenser.controller;

import com.dispenser.dto.EmployeeRequestDTO;
import com.dispenser.model.EfficiencyResponse;
import com.dispenser.service.EmployeeService;
import com.dispenser.util.EmployeeRequestDTOValidator;
import com.dispenser.util.MapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger employeeControllerLogger = Logger.getLogger(EmployeeController.class.getSimpleName());
    private final EmployeeService employeeService;
    private final Validator validator;

    @Autowired
    public EmployeeController(EmployeeService employeeService, @Qualifier("dtoValidator") Validator validator) {
        this.employeeService = employeeService;
        this.validator = validator;
    }

    @GetMapping("/best")
    public ResponseEntity<EfficiencyResponse> getEfficiencyEmployee(@RequestBody @Validated EmployeeRequestDTO employees , BindingResult bindingResult){

        validator.validate(employees, bindingResult);
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new EfficiencyResponse(String.valueOf(bindingResult.getAllErrors().get(0).getDefaultMessage())), HttpStatus.BAD_REQUEST);

        employeeControllerLogger.info("Пришло: " + employees);
        EfficiencyResponse efficiencyResponse = new EfficiencyResponse(
                employeeService.getBest(MapperDTO.convertToEmployeeRequest(employees).getEmployees())
        );
        employeeControllerLogger.info("Отдам: " + efficiencyResponse);
        return new ResponseEntity<>(efficiencyResponse, HttpStatus.OK);
    }


    


}
