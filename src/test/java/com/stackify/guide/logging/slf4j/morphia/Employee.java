package com.stackify.guide.logging.slf4j.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("employees")
@Indexes(
    @Index(value = "salary", fields = @Field("salary"))
)
class Employee {
    @Id
    private ObjectId id;

    private String name;

    @Reference
    private Employee manager;

    @Reference
    private List<Employee> directReports = new ArrayList<Employee>();

    @Property("wage")
    private Double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void addDirectReport(Employee employee) {
        directReports.add(employee);
    }
}
