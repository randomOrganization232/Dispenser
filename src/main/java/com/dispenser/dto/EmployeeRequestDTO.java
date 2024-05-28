package com.dispenser.dto;

import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDTO {
    private List<EmployeeDTO> employees;

    @Override
    public String toString() {
        return "EmployeeRequestDTO{" +
                "\nemployees=" + employees +
                '}';
    }
}
