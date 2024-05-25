package com.dispenser.model;

import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeRequest {
    private List<Employee> employees;

    @Override
    public String toString() {
        return "\nEmployeeRequest{" +
                "\nemployees=" + employees +
                '}';
    }
}
