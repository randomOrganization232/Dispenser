package com.dispenser.util;

import com.dispenser.model.Employee;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

public class DateSupport {

    public static final Logger dateSupportLogger = Logger.getLogger(DateSupport.class.getSimpleName());

    public static Date getAsDate(String date) {
        // String -> LocalDateTime -> ZonedDateTime -> Date
        return Date
                .from(
                        LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()
                );
    }

    public static long getDiff(Employee employee) {
        return Math.abs(employee.getDateEnd().getTime() - employee.getDateStart().getTime());
    }

    public static String getAsString(Employee employee) {

        Duration duration = Duration.ofMillis(getDiff(employee));
        String result = String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes() % 60, duration.getSeconds() % 60);
        dateSupportLogger.info("employee = " + employee);
        dateSupportLogger.info("result = " + result);
        dateSupportLogger.info("getDiff(employee) = " + getDiff(employee));
        return result;
    }

}
