import com.dispenser.dao.EmployeeDao;
import com.dispenser.dao.EmployeeDaoImpl;
import com.dispenser.model.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dispenser.util.DateSupport.getAsDate;


public class TestEmployeeDaoRepositoryImpl {

    @Test
    public void getNormalResult() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee first = Employee
                .builder()
                .id(1234)
                .dateStart(getAsDate("2023-03-23T10:25:08"))
                .dateEnd(getAsDate("2023-03-23T15:35:18"))
                .build();

        Employee second = Employee
                .builder()
                .id(4535)
                .dateStart(getAsDate("2023-03-23T10:25:08"))
                .dateEnd(getAsDate("2023-03-23T15:35:18"))
                .build();

        Employee third = Employee
                .builder()
                .id(1234)
                .dateStart(getAsDate("2023-03-24T08:25:08"))
                .dateEnd(getAsDate("2023-03-24T19:00:18"))
                .build();

        Employee bestEmployee = employeeDao.getBest(List.of(first, second, third));

        Assert.assertEquals(bestEmployee, first);
    }

}
