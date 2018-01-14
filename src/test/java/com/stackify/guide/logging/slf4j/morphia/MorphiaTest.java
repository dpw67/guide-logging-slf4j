package com.stackify.guide.logging.slf4j.morphia;

import com.mongodb.MongoClient;
import org.junit.jupiter.api.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MorphiaTest {
    static final Logger logger = LoggerFactory.getLogger(MorphiaTest.class);

    @Test
    void testMorphia() {

        // Create

        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.stackify.guide.logging.morphia");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
        datastore.ensureIndexes();

        // Save
        final Employee elmer = new Employee("Elmer Fudd", 50000.0);
        datastore.save(elmer);

        // Relations
        final Employee daffy = new Employee("Daffy Duck", 40000.0);
        datastore.save(daffy);

        final Employee pepe = new Employee("Pepé Le Pew", 25000.0);
        datastore.save(pepe);

        elmer.getDirectReports().add(daffy);
        elmer.getDirectReports().add(pepe);

        datastore.save(elmer);

        // Queries

        final Query<Employee> query = datastore.createQuery(Employee.class);
        final List<Employee> employees = query.asList();

        /**
        List<Employee> underpaid = datastore.createQuery(Employee.class)
                .field("salary").lessThanOrEq(30000)
                .asList();
         */

        List<Employee> underpaid = datastore.createQuery(Employee.class)
                .filter("salary <=", 30000)
                .asList();

        // Upfdate
        final Query<Employee> underPaidQuery = datastore.createQuery(Employee.class)
                .filter("salary <=", 30000);

        final UpdateOperations<Employee> updateOperations = datastore.createUpdateOperations(Employee.class)
                .inc("salary", 10000);

        final UpdateResults results = datastore.update(underPaidQuery, updateOperations);

        // Remove
        final Query<Employee> overPaidQuery = datastore.createQuery(Employee.class)
                .filter("salary >", 100000);

        datastore.delete(overPaidQuery);
    }

}
