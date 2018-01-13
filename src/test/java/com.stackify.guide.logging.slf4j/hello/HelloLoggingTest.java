package com.stackify.guide.logging.slf4j.hello;

import com.stackify.guide.logging.slf4j.employee.Employee;
import com.stackify.guide.logging.slf4j.employee.EmployeeService;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloLoggingTest {
    private static final Logger log =
            LoggerFactory.getLogger(HelloLoggingTest.class);

    @Test
    void testTraceLevel() {
        log.trace("ENTER: main.");
        log.info("Welcome to logging with the SLF4J API.");
        log.trace("EXIT: main.");
    }

    @Test
    void testLogLevels() {
        // Logging levels
        log.error("Action required!");
        log.warn("Might be a possible problem.");
        log.info("Useful in production logs.");
        log.debug("Information for developers.");
        log.trace("Log everything with details!");
    }

    @Test
    void testEnabled() {
        if (log.isErrorEnabled()) {
            log.error("Logger name: " + log.getName());
        }

        if (log.isWarnEnabled()) {
            log.warn("Logger name: " + log.getName());
        }

        if (log.isInfoEnabled()) {
            log.info("Logger name: " + log.getName());
        }

        if (log.isDebugEnabled()) {
            log.debug("Logger name: " + log.getName());
        }

        if (log.isTraceEnabled()) {
            log.trace("Logger name: " + log.getName());
        }
    }

    @Test
    void testParameterized_Level() {
        log.info("Parameterized logging at {} level", "INFO");
        log.debug("Parameterized logging at {} level", "DEBUG");
        log.trace("Parameterized logging at {} level", "TRACE");
    }

    @Test
    void testParameterized_Employee() {
        // Conditional logging (Logback or Log4J2 only, not SLF4J SimpleLogger)
        EmployeeService employeeService = new EmployeeService();
        Employee employee =  new Employee("John Doe");

        if (log.isDebugEnabled()) {
            log.debug("The bonus for employee: " +
                    employee.getName() + " is " +
                    employeeService.calculateBonus(employee));
        }
    }

    @Test
    void testParameterized_President() {
        // Parameterized logging (works with SimpleLogger)
        EmployeeService employeeService = new EmployeeService();
        Employee president =  new Employee("Donald Trump");

        log.debug("The bonus for president {} is {}",
                president.getName(), employeeService.calculateBonus(president));
    }

    @Test
    void testParameterized_Parameter_Methods() {
        log.debug("getString method call returns: {}", getString());
    }

    String getString() {
        log.debug("ENTER: getString...");
        return new String("getString Parameter");
    }

    @Test
    void testParameterized_LoggerName() {
        log.debug("Logger name: {}", log.getName());
    }

    @Test
    void testParameterized_Expression() {
        log.warn("Are you sure that the sum 1 + 1 equals {}?", 1 + 1);
    }
}
