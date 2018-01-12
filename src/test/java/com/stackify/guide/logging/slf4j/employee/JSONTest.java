package com.stackify.guide.logging.slf4j.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JSONTest {
    static final Logger log = LoggerFactory.getLogger(JSONTest.class);

    Employee employee = new Employee("John Doe");;
    ObjectMapper mapper = new ObjectMapper();

    @Test void testLogString() {
        log.debug(employee.logString());
    }

    @Test
    void testGsonMessage() {
        Gson gson = new Gson();
        log.debug("Employee (Gson object): {}", gson.toJson(employee));
    }

    @Test
    void testGsonPretty() {
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        log.debug("Employee (Gson pretty): \n{}", gsonPretty.toJson(employee));
    }

    @Test
    void testJackson() throws JsonProcessingException {
        String result = mapper.writeValueAsString(employee);
        log.debug("Employee (Jackson): {}", result);
    }

}
