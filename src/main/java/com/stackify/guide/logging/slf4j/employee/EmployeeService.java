package com.stackify.guide.logging.slf4j.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public int calculateBonus(Employee employee) {
        log.debug("Calculating bonus...");
        if (employee.getName().equals("Donald Trump")) {
            return 10000;
        }
        return 1000;
    }
}
