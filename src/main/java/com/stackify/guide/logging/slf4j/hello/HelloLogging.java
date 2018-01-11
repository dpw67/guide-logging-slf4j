package com.stackify.guide.logging.slf4j.hello;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class HelloLogging {
    private static final Logger log =
            LoggerFactory.getLogger(HelloLogging.class);
    public static void main(String[] args) {
        log.info("Welcome to logging with the SLF4j API.");
    }
}
