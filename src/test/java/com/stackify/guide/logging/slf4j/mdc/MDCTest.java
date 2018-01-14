package com.stackify.guide.logging.slf4j.mdc;

import com.stackify.guide.logging.slf4j.employee.Employee;
import com.stackify.guide.logging.slf4j.employee.EmployeeService;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.simple.SimpleLoggerFactory;
import org.slf4j.spi.MDCAdapter;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MDCTest {
    private static final Logger log =
            LoggerFactory.getLogger(MDCTest.class);

    @Test
    void testMDC() {
        log.trace("ENTER: testMDC.");
        log.info("Testing mapped diagnostic context (MDC) with SLF4J API.");
        log.trace("EXIT: testMDC.");
    }

    @Test
    void testPut() {
        // log.debug("Using SimpleLogger - MDC not implemented (NOP)...");

        MDCAdapter mdcAdapter = MDC.getMDCAdapter();
        String adapterName = mdcAdapter.getClass().getSimpleName();
        if (adapterName.startsWith("NOP")) {  // NOPMDCAdapter
            log.debug("Using SLF4J SimpleLogger with NOP MDC adapter...");
        }

        MDC.put("last", "Parker");

        String last = MDC.get("last");
        if (last != null) {
            log.debug("last: {}", last);
            // SLF4J: Returns null since MDC is not implemented (uses NOP adapter)
        }

        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        if (contextMap != null) {
            log.debug(contextMap.toString());
        }

        MDC.clear();
    }
}
