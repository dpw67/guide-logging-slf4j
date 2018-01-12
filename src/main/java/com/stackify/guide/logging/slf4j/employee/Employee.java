package com.stackify.guide.logging.slf4j.employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {
    private static final Logger log = LoggerFactory.getLogger(Employee.class);
    private String name;
    public Employee(String name) {setName(name);}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String logString() {
        return "Employee (logString) {" + "name='" + name + '\'' + '}';
    }
}
