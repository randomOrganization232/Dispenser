package com.dispenser.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String dateStart;
    private String dateEnd;

    @Override
    public String toString() {
        return "\nEmployeeDTO{" +
                "\nid=" + id +
                ", \ndateStart='" + dateStart + '\'' +
                ", \ndateEnd='" + dateEnd + '\'' +
                "}\n";
    }
}
