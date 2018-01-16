package com.stackify.guide.logging.spring.hello;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloSpringTest {
    private static final Logger log =
            LoggerFactory.getLogger(HelloSpringTest.class);

    @Test
    void testWelcome() {
        log.info("Testing a Spring Boot web application...");
        // Test something!
    }

}
