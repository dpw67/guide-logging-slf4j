package com.stackify.guide.logging.spring.greeting;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GreetingTest {
    private static final Logger log = LoggerFactory.getLogger(GreetingTest.class);

    @Test
    void testGreeting() {
        Greeting greeting = new Greeting(1, "Hello");
        log.debug(greeting.toString());
    }
}
