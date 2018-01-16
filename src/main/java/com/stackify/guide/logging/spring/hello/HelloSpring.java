package com.stackify.guide.logging.spring.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSpring {
    private static final Logger log = LoggerFactory.getLogger(HelloSpring.class);

    public static void main(String[] args) {
        log.info("Welcome to logging with the SLF4j API in a Spring Boot web application.");
    }
}
