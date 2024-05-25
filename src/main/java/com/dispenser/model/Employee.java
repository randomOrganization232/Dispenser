package com.dispenser.model;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Employee {
    private int id;
    private Date dateStart;
    private Date dateEnd;

    @Override
    public String toString() {
        return "\nEmployee{" +
                "\nid=" + id +
                ", \ndateStart=" + dateStart +
                ", \ndateEnd=" + dateEnd +
                "\n}\n";
    }
}
