package com.dispenser.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private int id;
    private String dateStart;
    private String dateEnd;

}
