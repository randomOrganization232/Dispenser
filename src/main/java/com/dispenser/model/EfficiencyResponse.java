package com.dispenser.model;

import com.dispenser.util.DateSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.logging.Logger;

@Setter
@Getter
@ToString
public class EfficiencyResponse {
    private static final Logger efficiencyResponseLogger = Logger.getLogger(EfficiencyResponse.class.getSimpleName());
    private int id;
    private String result;

    public EfficiencyResponse(Employee employee){
      this.id = employee.getId();
      this.result = DateSupport.getAsString(employee);
    }
}
