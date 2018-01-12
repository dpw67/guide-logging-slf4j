package com.stackify.guide.logging.slf4j.hello;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLoggingTest {
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
}
